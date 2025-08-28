package com.michaelspringproject.store;

public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        // Logic to process payment via Stripe
        System.out.println("Processing payment of Php: " + amount + " via Stripe.");
    }
}
