package com.xxahrutoxx.clientAndPerson.controllers;

import com.xxahrutoxx.clientAndPerson.entities.Person;
import com.xxahrutoxx.clientAndPerson.services.person.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientAndPerson/")
public class PersonController {
    @Autowired
    private IPersonService iPersonService;

    @PostMapping("person")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveClient(@RequestBody Person person){
        iPersonService.save(person);
    }

    @GetMapping("person/all")
    public ResponseEntity<?> findAllClient(){
        return ResponseEntity.ok(iPersonService.findAll());
    }

    @GetMapping("person/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iPersonService.findById(id));
    }
}
