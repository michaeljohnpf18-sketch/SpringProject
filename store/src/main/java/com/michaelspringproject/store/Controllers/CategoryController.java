package com.michaelspringproject.store.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelspringproject.store.dtos.CategoryDto;
import com.michaelspringproject.store.entities.Category;
import com.michaelspringproject.store.mappers.CategoryMapper;
import com.michaelspringproject.store.repositories.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepo;
    private final CategoryMapper categoryMapper; // ✅ inject mapper

    public CategoryController(CategoryRepository categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryRepo.findAll()
                .stream()
                .map(categoryMapper::toDto) // ✅ use instance, not static
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        Category category = categoryRepo.findById(id).orElse(null);
        if (category == null) {
            return ResponseEntity.notFound().build(); // Or throw an exception
        }
        return ResponseEntity.ok(categoryMapper.toDto(category)); // ✅ use instance
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody Category category) {
        Category saved = categoryRepo.save(category);
        return categoryMapper.toDto(saved); // ✅ use instance
    }
}
