package com.michaelspringproject.store.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import com.michaelspringproject.store.service.PaymentService;
import com.michaelspringproject.store.dtos.PaymentDto;
import com.michaelspringproject.store.mappers.PaymentMapper;
import com.michaelspringproject.store.entities.Payment;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;
    public PaymentController(PaymentService service) { this.service = service; }

    @GetMapping
    public List<PaymentDto> all() {
        return service.findAll().stream()
        .map(PaymentMapper::toDto)
        .toList();
    }

    @GetMapping("/{id}")
    public PaymentDto one(@PathVariable Long id) { return PaymentMapper.toDto(service.findById(id)); }

    @PostMapping
    public PaymentDto create(@RequestBody PaymentDto dto) {
        Payment e = PaymentMapper.toEntity(dto);
        Payment saved = service.save(e, dto.getOrderId());
        return PaymentMapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public PaymentDto update(@PathVariable Long id, @RequestBody PaymentDto dto) {
        Payment e = PaymentMapper.toEntity(dto);
        e.setId(id);
        Payment saved = service.save(e, dto.getOrderId());
        return PaymentMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
