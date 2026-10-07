package com.hotelbooking.onlinehotelbooking.controller;

import com.hotelbooking.onlinehotelbooking.model.User;
import com.hotelbooking.onlinehotelbooking.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        User result = userService.signup(user);

        if (result == null) {
            return "Email already registered";
        }

        return "Signup successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User result =
                userService.login(
                        user.getEmail(),
                        user.getPassword()
                );

        if (result == null) {
            return "Invalid email or password";
        }

        return "Login successful";
    }
}