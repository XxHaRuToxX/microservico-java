package com.xxahrutoxx.countAndMovement.dto;

import com.xxahrutoxx.countAndMovement.entities.Account;
import com.xxahrutoxx.countAndMovement.entities.Movement;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class AccountReportDTO {
    private String accountNumber;
    private Double balance;
    private List<MovementReportDTO> movementReportDTOList;

    public AccountReportDTO(Account account, List<Movement> movements) {
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getInitialAmount();
        this.movementReportDTOList = movements.stream()
                .map(MovementReportDTO::new)
                .collect(Collectors.toList());
    }
}
