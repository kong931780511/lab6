package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8919220369234965156L;
	public Inventory() {
		items = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
	
	private ArrayList<Item> items;

}
