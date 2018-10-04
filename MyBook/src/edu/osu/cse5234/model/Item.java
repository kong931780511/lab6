package edu.osu.cse5234.model;

public class Item {
	private String name;
	private String price;
	private String QuantityFields;
	public Item() {
		
	}
	public Item(String name, String price, String QuantityFields) {
		setName(name);
		setPrice(price);
		setQuantityFields(QuantityFields);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantityFields() {
		return QuantityFields;
	}
	public void setQuantityFields(String quantityFields) {
		this.QuantityFields = quantityFields;
	} 
}
