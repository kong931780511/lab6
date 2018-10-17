package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8919220369234965156L;
	public Inventory() {
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}

	
	
	
	private List<Item> items;
	public void setItems(List<Item> items) {
		this.items = items;
	}

}
