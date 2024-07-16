package com.xxahrutoxx.clientAndPerson.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
    private Long id;
    @NotEmpty(message = "It is required to complete the name field!")
    private String name;
    @NotEmpty(message = "It is required to complete the gender field!")
    private String gender;
    @NotNull(message = "It is required to complete the age field!")
    private int age;
    @NotEmpty(message = "It is required to complete the identification field!")
    private String identification;
    @NotEmpty(message = "It is required to complete the address field!")
    private String address;
    @NotEmpty(message = "It is required to complete the phone field!")
    private String phone;
}
