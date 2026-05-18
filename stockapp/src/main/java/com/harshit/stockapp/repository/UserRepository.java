package com.harshit.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.stockapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}