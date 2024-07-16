package com.xxahrutoxx.countAndMovement.controllers;


import com.xxahrutoxx.countAndMovement.dto.AccountReportDTO;
import com.xxahrutoxx.countAndMovement.dto.ClientReportDTO;
import com.xxahrutoxx.countAndMovement.entities.Movement;
import com.xxahrutoxx.countAndMovement.error.ErrorResponse;
import com.xxahrutoxx.countAndMovement.exceptions.InsufficientBalanceException;
import com.xxahrutoxx.countAndMovement.exceptions.ResourceNotFoundException;
import com.xxahrutoxx.countAndMovement.services.movement.IMovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/countAndMovement/movement/")
public class MovementController {
    @Autowired
    private IMovementService iMovementService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> saveAccount(@Valid @RequestBody Movement movement){
        try {
            Movement savedMovement = iMovementService.save(movement);
            return ResponseEntity.ok(savedMovement);
        }catch (ResourceNotFoundException e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    @GetMapping("all")
    public ResponseEntity<?> findAllMovement(){
        return ResponseEntity.ok(iMovementService.findAll());
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iMovementService.findById(id));
    }
//    @GetMapping("search-by-date")
//    public ResponseEntity<List<AccountReportDTO>> getReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//                                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
//        List<AccountReportDTO> report = iMovementService.getAccountsReport(startDate, endDate);
//        return ResponseEntity.ok(report);
//    }
    @GetMapping("search-by-date")
    public ResponseEntity<List<ClientReportDTO>> getReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        List<ClientReportDTO> report = iMovementService.getAccountsReport(startDate, endDate);
        return ResponseEntity.ok(report);
    }
}
