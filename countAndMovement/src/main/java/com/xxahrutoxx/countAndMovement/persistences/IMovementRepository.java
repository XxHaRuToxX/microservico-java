package com.xxahrutoxx.countAndMovement.persistences;

import com.xxahrutoxx.countAndMovement.entities.Account;
import com.xxahrutoxx.countAndMovement.entities.Movement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IMovementRepository extends CrudRepository<Movement, Long> {
//    List<Movement> findByDateBetweenAndAccount(Date startDate, Date endDate, Account account);
    List<Movement> findByAccount_AccountNumberAndDateBetween(String accountNumber, Date startDate, Date endDate);
}
