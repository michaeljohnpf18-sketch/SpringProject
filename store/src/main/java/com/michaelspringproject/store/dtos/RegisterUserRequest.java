package com.michaelspringproject.store.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String fullname;
    private String email;
    private String password;
    private String username;
    private String access;
}
