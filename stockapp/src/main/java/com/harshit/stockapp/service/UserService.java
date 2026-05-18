package com.harshit.stockapp.service;

import com.harshit.stockapp.model.User;
import com.harshit.stockapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }
    public User login(String email, String password) {

            User user = repo.findByEmail(email);

            if (user == null) {
                throw new RuntimeException("User not found");
            }

            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }

    return user;
}       
} 
