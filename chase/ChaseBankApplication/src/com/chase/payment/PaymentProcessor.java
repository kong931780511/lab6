package com.chase.payment;

public class PaymentProcessor {
  public String ping() {
   return "the bank is up and running for business...";
  }
  
  public String processPayment(CreditCardPayment creditCardPayment) {
   return "000000";
  }
}
