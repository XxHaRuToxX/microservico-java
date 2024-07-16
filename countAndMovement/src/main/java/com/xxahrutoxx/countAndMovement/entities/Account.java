package com.xxahrutoxx.countAndMovement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String accountNumber;
    private String typeAccount;
    private Double initialAmount;
    private Boolean stateAccount;
    @Column(name = "client_id")
    private Long clientId;
    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private List<Movement> movements;
}
