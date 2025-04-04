package com.myproject.desafio_picpay_backend.services;

import com.myproject.desafio_picpay_backend.dtos.UserDTO;
import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO dto){
        User newUser = new User(dto);

        saveUser(newUser);

        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User findUser(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

}
