package com.carvista.controller;

import com.carvista.model.User;
import com.carvista.repository.UserRepository;
import com.carvista.security.JwtUtil;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        // TODO: hash password before saving
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
    User existing = userRepository.findByEmail(user.getEmail());
    if (existing != null && existing.getPassword().equals(user.getPassword())) {
        return jwtUtil.generateToken(user.getEmail());
    }
    return "Invalid credentials";
}

}
