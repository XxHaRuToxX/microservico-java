package com.xxahrutoxx.clientAndPerson.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private String accountNumber;
    private String typeAccount;
    private Double initialAmount;
    private Boolean stateAccount;
    private Long clientId;
}
