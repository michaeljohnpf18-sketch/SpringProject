package com.michaelspringproject.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michaelspringproject.store.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
