package com.myproject.desafio_picpay_backend.repositories;

import com.myproject.desafio_picpay_backend.models.Transaction;
import com.myproject.desafio_picpay_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    boolean existsBySenderOrReceiver(User sender, User receiver);

}
