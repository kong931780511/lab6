package edu.osu.cse5234.model;
import java.util.*;

public class Order {
	
	public Order() {
		items = new ArrayList<Item>();
	}
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void setItem(int index, Item item) {
		items.set(index, item);
	}
	
	public void addItems(Item item) {
		items.add(item);
	}
	private ArrayList<Item> items;
}
