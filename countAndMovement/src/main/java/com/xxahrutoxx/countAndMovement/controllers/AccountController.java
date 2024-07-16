package com.xxahrutoxx.countAndMovement.controllers;

import com.xxahrutoxx.countAndMovement.entities.Account;
import com.xxahrutoxx.countAndMovement.services.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countAndMovement/account/")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveAccount(@RequestBody Account account){
        iAccountService.save(account);
    }

    @GetMapping("all")
    public ResponseEntity<?> findAllAccount(){
        return ResponseEntity.ok(iAccountService.findAll());
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iAccountService.findById(id));
    }

    @GetMapping("search-by-number/{accountNumber}")
    public ResponseEntity<?> findByIdAccountNumber(@PathVariable String accountNumber){
        return ResponseEntity.ok(iAccountService.findByAccountNumber(accountNumber));
    }

    @GetMapping("search-by-client/{idClient}")
    public ResponseEntity<?> findByIdClient(@PathVariable Long idClient){
        return ResponseEntity.ok(iAccountService.findByIdClient(idClient));
    }
}
