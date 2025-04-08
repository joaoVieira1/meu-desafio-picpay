package com.myproject.desafio_picpay_backend.services;

import com.myproject.desafio_picpay_backend.dtos.TransactionDTO;
import com.myproject.desafio_picpay_backend.models.Transaction;
import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.repositories.TransactionRepository;
import com.myproject.desafio_picpay_backend.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction doTransaction(TransactionDTO dto){
        User sender = this.userService.findUser(dto.senderId());
        User receiver = this.userService.findUser(dto.receiverId());

        Validator.balance(sender, dto.amount());
        Validator.userType(sender);

        Transaction transaction = createTransaction(dto, sender, receiver);
        setBalances(dto, sender, receiver);

        this.transactionRepository.save(transaction);

        return transaction;
    }

    public Transaction createTransaction(TransactionDTO dto, User sender, User receiver){
        Transaction newTransaction = new Transaction();

        newTransaction.setAmount(dto.amount());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimeStamp(LocalDateTime.now());

        return newTransaction;
    }

    public void setBalances(TransactionDTO dto, User sender, User receiver){

        sender.setBalance(sender.getBalance().subtract(dto.amount()));
        receiver.setBalance(receiver.getBalance().add(dto.amount()));

    }

    public List<Transaction> getAllTransactions(){
        return this.transactionRepository.findAll();
    }

    public boolean existsBySenderOrReceiver(User sender, User receiver){
        return this.transactionRepository.existsBySenderOrReceiver(sender, receiver);
    }
}
