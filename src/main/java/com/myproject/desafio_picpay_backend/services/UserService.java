package com.myproject.desafio_picpay_backend.services;

import com.myproject.desafio_picpay_backend.dtos.UserDTO;
import com.myproject.desafio_picpay_backend.models.User;
import com.myproject.desafio_picpay_backend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    private TransactionService transactionService;

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO dto){
        User newUser = new User(dto);

        encodePassword(newUser);

        saveUser(newUser);

        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User findUser(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public void encodePassword(User user){
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    }

    public boolean validatePassword(String passwordForm, String passwordDatabase){
        return this.passwordEncoder.matches(passwordForm, passwordDatabase);
    }

    @Transactional
    public void deleteUserById(Long id){
        User user = this.userRepository.findUserById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        boolean hasTransactions = this.transactionService.existsBySenderOrReceiver(user, user);

        if(hasTransactions){
            throw new IllegalStateException("Usuário não pode ser deletado pois já possui transações");
        }

        this.userRepository.delete(user);
    }

    @Transactional
    public User updateFirstNameUser(Long id, String firstName) throws Exception {
        User updateUser = findUser(id);

        updateUser.setFirstName(firstName);

        this.userRepository.save(updateUser);

        return updateUser;
    }

    @Transactional
    public User updateLastNameUser(Long id, String lastName) throws Exception{
        User updateUser = findUser(id);

        updateUser.setLastName(lastName);

        this.userRepository.save(updateUser);

        return updateUser;
    }

    @Transactional
    public User updatePasswordUser(Long id, String password) throws Exception{
        User updateUser = findUser(id);

        updateUser.setPassword(password);

        encodePassword(updateUser);

        this.userRepository.save(updateUser);

        return updateUser;
    }


}
