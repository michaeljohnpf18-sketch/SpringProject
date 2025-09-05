package com.michaelspringproject.store.mappers;

import com.michaelspringproject.store.entities.OrderItem;

public class OrderItemMapper {
    public static OrderItem toEntity(OrderItem orderItem) {
        if (orderItem == null) return null;
        OrderItem entity = new OrderItem();
        entity.setId(orderItem.getId());
        entity.setProduct(orderItem.getProduct());
        entity.setQuantity(orderItem.getQuantity());
        entity.setUnitPrice(orderItem.getUnitPrice());
        return entity;
    }
}
