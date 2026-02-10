package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    // ✅ LOGIN (ADD THIS)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        String token = authService.login(user.getEmail(), user.getPassword());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }

}
