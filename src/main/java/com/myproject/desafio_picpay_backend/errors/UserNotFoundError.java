package com.myproject.desafio_picpay_backend.errors;

public class UserNotFoundError extends RuntimeException{

    public UserNotFoundError(){
        super("Usuário não encontrado");
    }

}
