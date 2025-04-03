package com.myproject.desafio_picpay_backend.repositories;

import com.myproject.desafio_picpay_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
