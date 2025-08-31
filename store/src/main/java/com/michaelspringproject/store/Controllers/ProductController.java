package com.michaelspringproject.store.Controllers;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michaelspringproject.store.dtos.ProductDto;
import com.michaelspringproject.store.entities.Products;
import com.michaelspringproject.store.mappers.ProductMapper;
import com.michaelspringproject.store.repositories.ProductsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductsRepository productsRepository;    
    private final ProductMapper productMapper;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(
        @RequestParam(required = false, name = "categoryId") Long categoryId
    ) {
        List<Products> products;
        if(categoryId != null) {
            products = productsRepository.findByCategoryId(categoryId);
        } else {
            products = productsRepository.findAll();
        }
        return products.stream()
        .map(productMapper::toDto)
        .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var product = productsRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Or throw an exception
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }


}
