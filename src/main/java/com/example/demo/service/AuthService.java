package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REGISTER
    public User register(User user) {
        return userRepository.save(user);
    }

    // ✅ LOGIN
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        // 🔐 TEMP TOKEN (JWT baad me)
        return "LOGIN_SUCCESS_TOKEN";
    }
}
