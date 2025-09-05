package com.michaelspringproject.store.Controllers;

import java.util.List;
import java.util.Set;
import java.util.Locale.Category;

import org.springframework.data.domain.Sort;
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

import com.michaelspringproject.store.dtos.ProductDto;
import com.michaelspringproject.store.entities.Products;
import com.michaelspringproject.store.mappers.ProductMapper;
import com.michaelspringproject.store.repositories.CategoryRepository;
import com.michaelspringproject.store.repositories.ProductsRepository;

import lombok.AllArgsConstructor;
import lombok.experimental.var;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductsRepository productsRepository;    
    private final ProductMapper productMapper;

    @GetMapping
    public Iterable<ProductDto> getAllProducts(
        @RequestParam(required = false, name = "categoryId") 
        String sort, Long categoryId
    ) {
        List<Products> products;
        if(categoryId != null) {
            products = productsRepository.findByCategoryId(categoryId);
        } else {
            products = productsRepository.findAll(Sort.by(sort != null ? sort : "categoryId"));
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

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
        @RequestBody ProductDto productDto,
        UriComponentsBuilder uriBuilder) {
        

        // Create and save the product
        var product = productMapper.toEntity(productDto);
        productsRepository.save(product);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getProductId()).toUri();
        return ResponseEntity.created(uri).body(productDto);
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
        @PathVariable Long id,
        @RequestBody ProductDto request) {
        
        var product = productsRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Or throw an exception
        }

        // Update and save the product
        productMapper.updateEntity(request, product);
        productsRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        var product = productsRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Or throw an exception
        }
        productsRepository.delete(product);
        return ResponseEntity.noContent().build();
    }
}
