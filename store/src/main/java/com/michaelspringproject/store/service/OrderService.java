package com.michaelspringproject.store.service;

import com.michaelspringproject.store.entities.Order;
import com.michaelspringproject.store.entities.Users;
import com.michaelspringproject.store.repositories.OrderRepository;
import com.michaelspringproject.store.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    private final UserRepository userRepo;

    public OrderService(OrderRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<Order> findAll() { return repo.findAll(); }
    public Order findById(Long id) { return repo.findById(id).orElseThrow(); }
    public List<Order> findByUser(Long userId) { return repo.findByUserId(userId); }

    public Order save(Order order, Long userId) {
        if (userId != null) {
            Users u = userRepo.findById(userId).orElseThrow();
            order.setUser(u);
        }
        return repo.save(order);
    }

    public void delete(Long id) { repo.deleteById(id); }
}