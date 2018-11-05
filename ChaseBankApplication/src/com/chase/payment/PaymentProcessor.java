package com.chase.payment;

import java.util.Random;

public class PaymentProcessor {
	public String ping() {
		return("Bank is open for business!");
	}
	
	public String processPayment(CreditCardPayment ccPayment) {
		return(new Random().nextInt(1000000) + "");
	}
}
