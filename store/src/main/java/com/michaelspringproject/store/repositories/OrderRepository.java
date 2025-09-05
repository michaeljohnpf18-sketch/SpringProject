package com.michaelspringproject.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.michaelspringproject.store.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
