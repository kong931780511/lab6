package edu.osu.cse5234.model;

public class PaymentInfo {
	private String CreditCardNumber;
	private String ExpirationDate;
	private String cvvCode;
	private String CardHolderName;
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
