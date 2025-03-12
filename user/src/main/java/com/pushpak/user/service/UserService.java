package com.pushpak.user.service;

import com.pushpak.user.entity.User;
import com.pushpak.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return "Username already exists!";
        }
        else {
            userRepository.save(user);
            return "User registered successfully!";
        }
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return "Invalid username or password!";
        }

        else if(!password.equals(user.getPassword())) {
            return "Invalid username or password!";
        }

        return "Login successful!";
    }
}

