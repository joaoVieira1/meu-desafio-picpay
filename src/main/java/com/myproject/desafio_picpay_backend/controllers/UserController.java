package com.myproject.desafio_picpay_backend.controllers;

import com.myproject.desafio_picpay_backend.dtos.UserDTO;
import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto){
        User newUser = this.service.createUser(dto);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List users = this.service.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
