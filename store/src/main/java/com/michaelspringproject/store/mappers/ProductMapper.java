package com.michaelspringproject.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.michaelspringproject.store.dtos.ProductDto;
import com.michaelspringproject.store.entities.Products;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ProductMapper {   
    @Mapping(source = "categoryId", target = "categoryId")
    ProductDto toDto(Products product);
    Products toEntity(ProductDto productDto);
    Products updateEntity(ProductDto productDto, @MappingTarget Products product);
}
