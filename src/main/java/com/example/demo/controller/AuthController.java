package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user){

        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return authService.login(user.getUsername(), user.getPassword());

    }
}