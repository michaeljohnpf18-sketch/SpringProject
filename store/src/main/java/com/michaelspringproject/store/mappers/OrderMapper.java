package com.michaelspringproject.store.mappers;

import com.michaelspringproject.store.entities.Order;
import com.michaelspringproject.store.dtos.OrderDto;

public class OrderMapper {
    public static OrderDto toDto(Order e) {
        if (e == null) return null;
        OrderDto d = new OrderDto();
        d.setId(e.getId());
        d.setStatus(e.getStatus());
        d.setTotalAmount(e.getTotalAmount());
        if (e.getUser() != null) d.setUserId(e.getUser().getId());
        return d;
    }
    public static Order toEntity(OrderDto d) {
        if (d == null) return null;
        Order e = new Order();
        e.setId(d.getId());
        e.setStatus(d.getStatus());
        e.setTotalAmount(d.getTotalAmount());
        return e;
    }
}
