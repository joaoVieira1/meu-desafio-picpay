package com.myproject.desafio_picpay_backend.repositories;

import com.myproject.desafio_picpay_backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
