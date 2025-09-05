package com.michaelspringproject.store.mappers;

import org.mapstruct.Mapper;

import com.michaelspringproject.store.dtos.CategoryDto;
import com.michaelspringproject.store.entities.Category;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto dto);
}