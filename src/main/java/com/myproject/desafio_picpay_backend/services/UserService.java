package com.myproject.desafio_picpay_backend.services;

import com.myproject.desafio_picpay_backend.dtos.UserDTO;
import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO dto){
        User newUser = new User(dto);

        saveUser(newUser);

        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

}
