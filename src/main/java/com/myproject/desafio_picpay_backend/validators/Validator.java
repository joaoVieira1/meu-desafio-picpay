package com.myproject.desafio_picpay_backend.validators;

import com.myproject.desafio_picpay_backend.errors.InsufficientBalanceError;
import com.myproject.desafio_picpay_backend.errors.UserTypeError;
import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.models.UserType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Validator {

    public static void balance(User user, BigDecimal amount){
        if(user.getBalance().compareTo(amount) < 0){
            throw new InsufficientBalanceError();
        }
    }

    public static void userType(User user){
        if(user.getUserType() == UserType.MERCHANT) {
            throw new UserTypeError();
        }
    }

}
