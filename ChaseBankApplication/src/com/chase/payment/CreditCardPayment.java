package com.chase.payment;

import java.io.Serializable;

public class CreditCardPayment implements Serializable{
 /**
	 * 
	 */
private static final long serialVersionUID = -1275190678657849683L;
public CreditCardPayment() {}

 
 private String CreditCardNumber;
 private String CardHolderName;
 private String ExpirationDate;
 private String cvvCode;
 private int paymentAmount;
 public String getCreditCardNumber() {
  return CreditCardNumber;
 }
 public void setCreditCardNumber(String creditCardNumber) {
  this.CreditCardNumber = creditCardNumber;
 }
 public String getCardHolderName() {
  return CardHolderName;
 }
 public void setCardHolderName(String cardHolderName) {
  this.CardHolderName = cardHolderName;
 }
 public String getExpirationDate() {
  return ExpirationDate;
 }
 public void setExpirationDate(String expirationDate) {
  this.ExpirationDate = expirationDate;
 }
 public String getCvvCode() {
  return cvvCode;
 }
 public void setCvvCode(String cvvCode) {
  this.cvvCode = cvvCode;
 }
 public int getPaymentAmount() {
  return paymentAmount;
 }
 public void setPaymentAmount(int paymentAmount) {
  this.paymentAmount = paymentAmount;
 }
 
 
}
