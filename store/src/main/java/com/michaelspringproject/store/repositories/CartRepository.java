package com.michaelspringproject.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michaelspringproject.store.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
