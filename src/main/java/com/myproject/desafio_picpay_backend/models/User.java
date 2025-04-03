package com.myproject.desafio_picpay_backend.models;

import com.myproject.desafio_picpay_backend.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO dto){
        setFirstName(dto.firstName());
        setLastName(dto.lastName());
        setDocument(dto.document());
        setEmail(dto.email());
        setPassword(dto.password());
        setBalance(dto.balance());
        setUserType(dto.userType());
    }

}
