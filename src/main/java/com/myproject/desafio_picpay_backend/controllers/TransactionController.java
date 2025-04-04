package com.myproject.desafio_picpay_backend.controllers;

import com.myproject.desafio_picpay_backend.dtos.TransactionDTO;
import com.myproject.desafio_picpay_backend.models.Transaction;
import com.myproject.desafio_picpay_backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO dto) throws Exception {
        Transaction transaction = transactionService.doTransaction(dto);

        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = this.transactionService.getAllTransactions();

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
