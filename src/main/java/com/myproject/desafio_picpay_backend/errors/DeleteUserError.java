package com.myproject.desafio_picpay_backend.errors;

public class DeleteUserError extends RuntimeException{

    public DeleteUserError(){
        super("Esse usuário não pode ser removido pois já possui transações cadastradas");
    }

}
