package com.michaelspringproject.store.Controllers; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.michaelspringproject.store.dtos.RegisterUserRequest;
import com.michaelspringproject.store.dtos.UpdateUserRequest;
import com.michaelspringproject.store.dtos.UserDto;
import com.michaelspringproject.store.mappers.UserMapper;
import com.michaelspringproject.store.repositories.UserRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers() {
        // Logic to retrieve all users
        return userRepository.findAll() 
        .stream()
        .map(userMapper::toDto)
        .toList();
    } 

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        // Logic to retrieve a user by ID
        var user = userRepository.findById(id).orElse(null); // Replace with actual user retrieval
        if (user == null) {
            // Handle user not found case
           return ResponseEntity.notFound().build();   // Or throw an exception

        } 
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto>  createUser(
        @RequestBody RegisterUserRequest request,
        UriComponentsBuilder uriBuilder) {

        var user = userMapper.toEntity(request);
        userRepository.save(user);
        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);          
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
        @PathVariable Long id,
        @RequestBody UpdateUserRequest request
    ) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build(); // Or throw an exception
        }
        userMapper.updateEntity(request, user);
        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build(); // Or throw an exception
        }
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
