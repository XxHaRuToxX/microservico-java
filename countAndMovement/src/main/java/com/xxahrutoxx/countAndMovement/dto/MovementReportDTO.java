package com.xxahrutoxx.countAndMovement.dto;

import com.xxahrutoxx.countAndMovement.entities.Movement;
import lombok.Data;

import java.util.Date;

@Data
public class MovementReportDTO {
    private Date date;
    private String typeMovement;
    private Double value;
    private Double amount;

    public MovementReportDTO(Movement movement) {
        this.date = movement.getDate();
        this.typeMovement = movement.getTypeMovement();
        this.value = movement.getValue();
        this.amount = movement.getAmount();
    }
}
