package com.michaelspringproject.store;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StoreApplication.class, args);
		//var paymentService = new GcashPaymentService();
		var orderService = new OrderService();
		//orderService.setPaymentService(new GcashPaymentService());
		orderService.placeOrder();
	}

}
