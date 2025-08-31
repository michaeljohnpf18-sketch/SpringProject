package com.michaelspringproject.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.michaelspringproject.store.dtos.ProductDto;
import com.michaelspringproject.store.entities.Products;

@Mapper(componentModel = "spring")
public interface ProductMapper {   
    @Mapping(source = "categoryId", target = "categoryId")
    ProductDto toDto(Products product);
}
