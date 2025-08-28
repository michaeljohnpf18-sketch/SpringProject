package com.michaelspringproject.store;


public class OrderService {

    private PaymentService paymentService;
    // public OrderService(PaymentService paymentService) {
    //     this.paymentService = paymentService;
    // }

    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;

    }


    public void placeOrder() {
        // Logic to place an order
       paymentService.processPayment(1000.0);
    }
}
