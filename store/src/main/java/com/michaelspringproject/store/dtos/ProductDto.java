package com.michaelspringproject.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private String productName;
    private String description;
    private double price;
    private Long categoryId; 
    
}
                        