package com.michaelspringproject.store.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelspringproject.store.entities.Users;
import com.michaelspringproject.store.repositories.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
