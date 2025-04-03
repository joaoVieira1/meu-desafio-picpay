package com.myproject.desafio_picpay_backend.dtos;

import com.myproject.desafio_picpay_backend.models.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, String email, String password, BigDecimal balance, UserType userType) {
}
