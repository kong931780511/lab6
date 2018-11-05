package com.chase.payment;

import java.io.Serializable;


public class CreditCardPayment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreditCardPayment() {}

	private int id;

	private String CreditCardNumber;

	private String ExpirationDate;

	private String cvvCode;

	private String CardHolderName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.CreditCardNumber = creditCardNumber;
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
	public String getCardHolderName() {
		return CardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.CardHolderName = cardHolderName;
	}
}
