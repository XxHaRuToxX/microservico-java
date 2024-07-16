package com.xxahrutoxx.clientAndPerson.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@Entity
//@Builder
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "person_id")
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long clientId;
    @NotEmpty(message = "It is required to complete the password field!")
    @Size(min = 6, message = "The password must have 6 character!")
    private String password;
    @NotNull(message = "The state field can not be null")
    private boolean state;
}
