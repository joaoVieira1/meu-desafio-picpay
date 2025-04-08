package com.myproject.desafio_picpay_backend.errors;

public class UserTypeError extends RuntimeException{

    public UserTypeError(){
        super("Esse tipo de usuário não pode realizar transações");
    }

}
