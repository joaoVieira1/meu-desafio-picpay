package com.myproject.desafio_picpay_backend.infra;

import com.myproject.desafio_picpay_backend.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(DatasExistsError.class)
    public ResponseEntity<Object> handlerDatasExistsError(DatasExistsError e){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 409, e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DeleteUserError.class)
    public ResponseEntity<Object> handlerDeleteUserError(DeleteUserError e){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 409, e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InsufficientBalanceError.class)
    public ResponseEntity<Object> handlerInsufficientBalanceError(InsufficientBalanceError e){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 422, e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotFoundError.class)
    public ResponseEntity<Object> handlerUserNotFoundError(UserNotFoundError e){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 404, e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserTypeError.class)
    public ResponseEntity<Object> handlerUserTypeError(UserTypeError e){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), 422, e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
