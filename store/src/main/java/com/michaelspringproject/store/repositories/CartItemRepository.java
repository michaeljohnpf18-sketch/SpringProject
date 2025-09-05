package com.michaelspringproject.store.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.michaelspringproject.store.entities.CartItem;

public interface CartItemRepository extends JpaRepository <CartItem, Long> {
    
}
