package com.xxahrutoxx.clientAndPerson.controllers;

import com.xxahrutoxx.clientAndPerson.Exceptions.ResourceNotFoundException;
import com.xxahrutoxx.clientAndPerson.entities.Client;
import com.xxahrutoxx.clientAndPerson.error.ErrorResponse;
import com.xxahrutoxx.clientAndPerson.services.client.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/clientAndPerson/")
public class ClientController {
    @Autowired
    private IClientService iClientService;

    @PostMapping("client")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Client> saveClient(@Valid @RequestBody Client client){
        Client clientSaved = iClientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }

    @GetMapping("all")
    public ResponseEntity<?> findAllClient(){
        return ResponseEntity.ok(iClientService.findAll());
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iClientService.findById(id));
    }

    @PutMapping("client/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client) {
        try {
            Client clientUpdated = iClientService.update(id, client);
            return ResponseEntity.ok(clientUpdated);
        }catch (ResourceNotFoundException e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @GetMapping("search-accounts/{idAccount}")
    public ResponseEntity<?> findAllAccountsByClient(@PathVariable Long idAccount){
        return ResponseEntity.ok((iClientService.findAccountsByIdClient(idAccount)));
    }
}
