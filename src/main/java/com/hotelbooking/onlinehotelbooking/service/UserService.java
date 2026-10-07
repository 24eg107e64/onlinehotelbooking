package com.hotelbooking.onlinehotelbooking.service;

import com.hotelbooking.onlinehotelbooking.model.User;
import com.hotelbooking.onlinehotelbooking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(User user) {

        Optional<User> existingUser =
                userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return null;
        }

        return userRepository.save(user);
    }

    public User login(String email, String password) {

        Optional<User> user =
                userRepository.findByEmail(email);

        if (user.isPresent()
                && user.get().getPassword().equals(password)) {

            return user.get();
        }

        return null;
    }
}