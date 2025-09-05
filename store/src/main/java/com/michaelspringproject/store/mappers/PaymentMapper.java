package com.michaelspringproject.store.mappers;

import com.michaelspringproject.store.dtos.PaymentDto;
import com.michaelspringproject.store.entities.Payment;

public class PaymentMapper {
     public static Payment toEntity(PaymentDto dto) {  // ✅ now accepts PaymentDto
        Payment entity = new Payment();
        entity.setId(dto.getId());
        entity.setMethod(dto.getMethod());
        entity.setStatus(dto.getStatus());
        entity.setAmount(dto.getAmount());
        entity.setTransactionId(dto.getTransactionId());
        // order must be set in the service using orderId
        return entity;
    }
    public static PaymentDto toDto(Payment entity) {  // ✅ must return DTO
        PaymentDto dto = new PaymentDto();
        dto.setId(entity.getId());
        dto.setMethod(entity.getMethod());
        dto.setStatus(entity.getStatus());
        dto.setAmount(entity.getAmount());
        dto.setTransactionId(entity.getTransactionId());
        dto.setOrderId(entity.getOrder().getId());
        return dto;
    }
}
