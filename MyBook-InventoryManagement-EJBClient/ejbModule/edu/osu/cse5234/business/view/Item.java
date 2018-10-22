package edu.osu.cse5234.business.view;

import java.io.Serializable;

import javax.persistence.*;

@Entity 
@Table(name="ITEM") 
public class Item implements Serializable{
	
	
	public Item() {}
	
	private static final long serialVersionUID = 9158635689741005180L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="UNIT_PRICE")
	private double unitPrice;
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Column(name="AVAILABLE_QUANTITY")
	private int availableQuantity;
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	@Column(name="DESCRIPTION")
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
