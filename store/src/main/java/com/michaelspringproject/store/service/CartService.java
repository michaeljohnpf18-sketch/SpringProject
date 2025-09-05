package com.michaelspringproject.store.service;

import com.michaelspringproject.store.entities.Cart;
import com.michaelspringproject.store.entities.Users;
import com.michaelspringproject.store.repositories.CartRepository;
import com.michaelspringproject.store.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository repo;
    private final UserRepository userRepo;

    public CartService(CartRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<Cart> findAll() { return repo.findAll(); }
    public Cart findById(Long id) { return repo.findById(id).orElseThrow(); }

    public Cart save(Cart c, Long userId) {
        if (userId != null) {
            Users u = userRepo.findById(userId).orElseThrow();
            c.setUser(u);
        }
        return repo.save(c);
    }

    public void delete(Long id) { repo.deleteById(id); }
}