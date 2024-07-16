package com.xxahrutoxx.countAndMovement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @NotEmpty(message = "It is required to complete the typeMovement field!")
    private String typeMovement;
    @NotNull(message = "It is required to complete the value field!")
    private Double value;
    private Double amount;
    @ManyToOne
//    @JoinColumn(name = "account_id", nullable = false)
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber", nullable = false)
    @JsonBackReference
    private Account account;
}
