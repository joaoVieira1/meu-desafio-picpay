package com.myproject.desafio_picpay_backend.errors;

public class InsufficientBalanceError extends RuntimeException{

    public InsufficientBalanceError(){
        super("Saldo insuficiente para realizar a transação");
    }

}
