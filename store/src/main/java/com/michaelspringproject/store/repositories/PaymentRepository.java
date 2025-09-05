package com.michaelspringproject.store.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.michaelspringproject.store.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
