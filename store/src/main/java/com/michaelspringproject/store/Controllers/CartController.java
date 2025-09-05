package com.michaelspringproject.store.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import com.michaelspringproject.store.dtos.CartDto;
import com.michaelspringproject.store.mappers.CartMapper;
import com.michaelspringproject.store.entities.Cart;
import com.michaelspringproject.store.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private final CartService service;
    public CartController(CartService service) { this.service = service; }

    @GetMapping
    public List<CartDto> all() { return service.findAll().stream().map(CartMapper::toDto).collect(Collectors.toList()); }

    @GetMapping("/{id}")
    public CartDto one(@PathVariable Long id) { return CartMapper.toDto(service.findById(id)); }

    @PostMapping
    public CartDto create(@RequestBody CartDto dto) {
        Cart e = CartMapper.toEntity(dto);
        Cart saved = service.save(e, dto.getUserId());
        return CartMapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public CartDto update(@PathVariable Long id, @RequestBody CartDto dto) {
        Cart e = CartMapper.toEntity(dto);
        e.setId(id);
        Cart saved = service.save(e, dto.getUserId());
        return CartMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
