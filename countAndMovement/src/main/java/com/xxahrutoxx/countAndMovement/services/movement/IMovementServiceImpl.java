package com.xxahrutoxx.countAndMovement.services.movement;

import com.xxahrutoxx.countAndMovement.dto.AccountReportDTO;
import com.xxahrutoxx.countAndMovement.dto.ClientReportDTO;
import com.xxahrutoxx.countAndMovement.entities.Account;
import com.xxahrutoxx.countAndMovement.entities.Movement;
import com.xxahrutoxx.countAndMovement.exceptions.InsufficientBalanceException;
import com.xxahrutoxx.countAndMovement.exceptions.ResourceNotFoundException;
import com.xxahrutoxx.countAndMovement.persistences.IAccountRepository;
import com.xxahrutoxx.countAndMovement.persistences.IMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IMovementServiceImpl implements IMovementService {
    @Autowired
    private IMovementRepository iMovementRepository;
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public List<Movement> findAll() {
        return (List<Movement>) iMovementRepository.findAll();
    }

    @Override
    public Movement findById(Long id) {
        return iMovementRepository.findById(id).orElseThrow();
    }

    @Override
    public Movement save(Movement movement) {

        String accountNumber = movement.getAccount().getAccountNumber();
        // Get the account who is linked to the movement
        Account account = iAccountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found: " + movement.getAccount().getAccountNumber()));

        movement.setAccount(account);

        movement.setDate(new Date());

        // Verify the type of movement and update the amount account
        if (movement.getTypeMovement().equalsIgnoreCase("Retiro")) {
            if (account.getInitialAmount() < movement.getValue()) {
                throw new InsufficientBalanceException("Saldo no disponible");
            }
            account.setInitialAmount(account.getInitialAmount() - movement.getValue());
        } else if (movement.getTypeMovement().equalsIgnoreCase("Deposito")) {
            account.setInitialAmount(account.getInitialAmount() + movement.getValue());
        }

        // Save the updated account
        movement.setAmount(account.getInitialAmount());
        iAccountRepository.save(account);

        // Save the movement
        return iMovementRepository.save(movement);
//        return iMovementRepository.save(movement);
    }

    /*@Override
    public List<AccountReportDTO> getAccountsReport(Date startDate, Date endDate) {
        List<Account> accounts = (List<Account>) iAccountRepository.findAll();
        List<AccountReportDTO> accountReports = new ArrayList<>();

        for (Account account : accounts) {
            List<Movement> movements = iMovementRepository.findByDateBetweenAndAccount(startDate, endDate, account);
            AccountReportDTO accountReport = new AccountReportDTO(account, movements);
            accountReports.add(accountReport);
        }

        return accountReports;
    }*/
    public List<ClientReportDTO> getAccountsReport(Date startDate, Date endDate) {
        List<Account> accounts = (List<Account>) iAccountRepository.findAll();
        Map<Long, ClientReportDTO> clientReportMap = new HashMap<>();

        for (Account account : accounts) {
            List<Movement> movements = iMovementRepository.findByAccount_AccountNumberAndDateBetween(account.getAccountNumber(), startDate, endDate);

            AccountReportDTO accountReport = new AccountReportDTO(account, movements);
            ClientReportDTO clientReport = clientReportMap.computeIfAbsent(account.getClientId(), k -> new ClientReportDTO(account.getClientId()));

            clientReport.addAccountReport(accountReport);
        }

        return new ArrayList<>(clientReportMap.values());
    }
}
