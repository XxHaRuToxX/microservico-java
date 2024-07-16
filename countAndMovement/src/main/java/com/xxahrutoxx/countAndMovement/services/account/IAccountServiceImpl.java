package com.xxahrutoxx.countAndMovement.services.account;

import com.xxahrutoxx.countAndMovement.entities.Account;
import com.xxahrutoxx.countAndMovement.persistences.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public List<Account> findAll() {
        return (List<Account>) iAccountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return iAccountRepository.findById(id).orElseThrow();
    }
    @Override
    public Account findByAccountNumber(String accountNumber) {
        return iAccountRepository.findByAccountNumber(accountNumber).orElseThrow();
    }
    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public List<Account> findByIdClient(Long idClient) {
        return iAccountRepository.findAllAccount(idClient);
    }

}
