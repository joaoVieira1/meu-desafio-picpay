package com.myproject.desafio_picpay_backend.dtos;

import com.myproject.desafio_picpay_backend.models.User;

import java.math.BigDecimal;

public record TransactionDTO(Long senderId, Long receiverId, BigDecimal amount) {
}
