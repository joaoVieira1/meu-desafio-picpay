package com.myproject.desafio_picpay_backend.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="Users")
@EqualsAndHashCode(of="id")
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    private String password;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}
