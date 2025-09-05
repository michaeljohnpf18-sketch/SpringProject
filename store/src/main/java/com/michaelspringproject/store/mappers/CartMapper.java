package com.michaelspringproject.store.mappers;

import com.michaelspringproject.store.dtos.CartDto;
import com.michaelspringproject.store.entities.Cart;

public class CartMapper {
    public static CartDto toDto(Cart cart) {
        if (cart == null) return null;
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUser().getId());
        return dto;
    }
    public static Cart toEntity(CartDto dto) {
        if (dto == null) return null;
        Cart cart = new Cart();
        cart.setId(dto.getId());
        return cart;
    }
}
