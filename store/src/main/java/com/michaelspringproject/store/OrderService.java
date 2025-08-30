package com.michaelspringproject.store;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }    

    public void placeOrder() {
        // Logic to place an order
       paymentService.processPayment(1000.0);
    }

    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
}
