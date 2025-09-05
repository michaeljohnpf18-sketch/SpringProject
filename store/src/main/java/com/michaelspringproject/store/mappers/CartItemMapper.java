package com.michaelspringproject.store.mappers;

import com.michaelspringproject.store.dtos.CartItemDto;
import com.michaelspringproject.store.entities.CartItem;

public class CartItemMapper {
    public static CartItemDto toDto(CartItem cartItem) {
        if (cartItem == null) return null;
        CartItemDto dto = new CartItemDto();
        dto.setId(cartItem.getId());
        dto.setCartId(cartItem.getCart().getId());
        dto.setProductId(cartItem.getProduct().getProductId());
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }
    public static CartItem toEntity(CartItemDto dto) {
        if (dto == null) return null;
        CartItem cartItem = new CartItem();
        cartItem.setId(dto.getId());
        cartItem.setQuantity(dto.getQuantity());
        return cartItem;
    }
}
