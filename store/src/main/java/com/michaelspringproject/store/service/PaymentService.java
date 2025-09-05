package com.michaelspringproject.store.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.michaelspringproject.store.entities.Payment;
import com.michaelspringproject.store.entities.Order;
import com.michaelspringproject.store.repositories.PaymentRepository;
import com.michaelspringproject.store.repositories.OrderRepository;

@Service
public class PaymentService {
    private final PaymentRepository repository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository repository, OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    public List<Payment> findAll() {
        return repository.findAll(); // returns entities
    }

    public Payment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found: " + id));
    }

    public Payment save(Payment payment, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        payment.setOrder(order);
        return repository.save(payment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}