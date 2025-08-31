package com.michaelspringproject.store.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String fullname;
    private String email;
}
