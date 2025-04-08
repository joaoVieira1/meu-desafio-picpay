package com.myproject.desafio_picpay_backend.errors;

public class DatasExistsError extends RuntimeException {

    public DatasExistsError(){
        super("Documento ou email já cadastrados");
    }

}
