package com.michaelspringproject.store;

import org.springframework.stereotype.Service;

@Service
public class GcashPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        // Logic to process payment via Gcash
        System.out.println("Processing payment of Php: " + amount + " via Gcash.");
    }

}
