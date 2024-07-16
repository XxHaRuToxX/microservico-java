package com.xxahrutoxx.clientAndPerson.http.response;

import com.xxahrutoxx.clientAndPerson.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountByClientResponse {
    private String clientName;
    private String identificationClient;
    private String addressClient;
    private String phoneClient;
    private List<AccountDTO> accountDTOList;
}
