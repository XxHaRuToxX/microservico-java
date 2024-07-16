package com.xxahrutoxx.countAndMovement.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientReportDTO {
    private Long clientId;
    private List<AccountReportDTO> accounts = new ArrayList<>();

    public ClientReportDTO(Long clientId) {
        this.clientId = clientId;
    }

    public void addAccountReport(AccountReportDTO accountReport) {
        this.accounts.add(accountReport);
    }
}
