package com.xxahrutoxx.countAndMovement.services.account;


import com.xxahrutoxx.countAndMovement.entities.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(Long id);
    Account findByAccountNumber(String accountNumber);
    void save(Account account);
    List<Account> findByIdClient(Long idClient);
}
