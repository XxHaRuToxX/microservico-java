package com.xxahrutoxx.countAndMovement.persistences;

import com.xxahrutoxx.countAndMovement.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT s FROM Account s WHERE s.clientId = :idClient")
    List<Account> findAllAccount(Long idClient);
//    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    Optional<Account> findByAccountNumber(String accountNumber);

}
