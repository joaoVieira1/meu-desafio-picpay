package com.myproject.desafio_picpay_backend.controllers;

import com.myproject.desafio_picpay_backend.dtos.UpdateFirstNameDTO;
import com.myproject.desafio_picpay_backend.dtos.UpdateLastNameDTO;
import com.myproject.desafio_picpay_backend.dtos.UpdatePasswordDTO;
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
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto){
        User newUser = this.userService.createUser(dto);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List users = this.userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        this.userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/firstName")
    public ResponseEntity<User> updateFirstNameUser(@PathVariable Long id, @RequestBody UpdateFirstNameDTO updateFirstNameDTO) throws Exception {
        User updateUser = this.userService.updateFirstNameUser(id, updateFirstNameDTO.firstName());

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}/lastName")
    public ResponseEntity<User> updateLastNameUser(@PathVariable Long id, @RequestBody UpdateLastNameDTO updateLastNameDTO) throws Exception {
        User updateUser = this.userService.updateLastNameUser(id, updateLastNameDTO.lastName());

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<User> updatePasswordUser(@PathVariable Long id, @RequestBody UpdatePasswordDTO updatePasswordDTO) throws Exception{
        User updateUser = this.userService.updatePasswordUser(id, updatePasswordDTO.password());

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

}
