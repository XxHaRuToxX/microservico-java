package com.xxahrutoxx.clientAndPerson.client;

import com.xxahrutoxx.clientAndPerson.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-countAndMovement", url = "localhost:8080/api/countAndMovement/account/")
public interface IAccountClient {
    @GetMapping("search-by-client/{idClient}")
    List<AccountDTO> findAllAccountByClient(@PathVariable Long idClient);
}
