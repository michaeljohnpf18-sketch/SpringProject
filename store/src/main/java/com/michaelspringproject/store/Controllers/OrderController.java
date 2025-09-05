package com.michaelspringproject.store.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import com.michaelspringproject.store.dtos.OrderDto;
import com.michaelspringproject.store.mappers.OrderMapper;
import com.michaelspringproject.store.entities.Order;
import com.michaelspringproject.store.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @GetMapping
    public List<OrderDto> all() { return service.findAll().stream().map(OrderMapper::toDto).collect(Collectors.toList()); }

    @GetMapping("/{id}")
    public OrderDto one(@PathVariable Long id) { return OrderMapper.toDto(service.findById(id)); }

    @GetMapping("/user/{userId}")
    public List<OrderDto> byUser(@PathVariable Long userId) {
        return service.findByUser(userId).stream().map(OrderMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto dto) {
        Order e = OrderMapper.toEntity(dto);
        Order saved = service.save(e, dto.getUserId());
        return OrderMapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public OrderDto update(@PathVariable Long id, @RequestBody OrderDto dto) {
        Order e = OrderMapper.toEntity(dto);
        e.setId(id);
        Order saved = service.save(e, dto.getUserId());
        return OrderMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}

