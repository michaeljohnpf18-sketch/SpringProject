package com.michaelspringproject.store.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelspringproject.store.entities.Users;
import com.michaelspringproject.store.repositories.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<Users> getAllUsers() {
        // Logic to retrieve all users
        return userRepository.findAll(); // Replace with actual user list
    } 
}
