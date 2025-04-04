package com.myproject.desafio_picpay_backend.validators;

import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.models.UserType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Validator {

    public static void balance(User user, BigDecimal amount) throws Exception {
        if(user.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente para realizar transação");
        }
    }

    public static void userType(User user) throws Exception {
        if(user.getUserType() == UserType.MERCHANT) {
            throw new Exception("Tipo de usuário não permitido para transação");
        }
    }

}
