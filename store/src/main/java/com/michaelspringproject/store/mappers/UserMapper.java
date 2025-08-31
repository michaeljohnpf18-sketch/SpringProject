package com.michaelspringproject.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.michaelspringproject.store.dtos.RegisterUserRequest;
import com.michaelspringproject.store.dtos.UpdateUserRequest;
import com.michaelspringproject.store.dtos.UserDto;
import com.michaelspringproject.store.entities.Users;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
     UserDto toDto(Users user);
     Users toEntity(RegisterUserRequest request);
     void updateEntity(UpdateUserRequest request, @MappingTarget Users user);
} 

