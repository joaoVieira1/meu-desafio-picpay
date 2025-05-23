package com.myproject.desafio_picpay_backend.repositories;

import com.myproject.desafio_picpay_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
    void deleteUserById(Long id);
    boolean existsByEmail(String email);
    boolean existsByDocument(String document);

}
