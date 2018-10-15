package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public Inventory getAvailableInventory() {
		//ArrayList<Item> items = new ArrayList<>();
		Inventory inventory=new Inventory();
		inventory.addItem(new Item("CPP", "80", "0"));
		inventory.addItem(new Item("Python", "70", "0"));
		inventory.addItem(new Item("Java", "60", "0"));
		inventory.addItem(new Item("JS", "20", "0"));
		inventory.addItem(new Item("HTML", "10", "0"));
		//Inventory inventory=new Inventory();
		//inventory.addItem(items);
		return inventory;
	}
	public boolean validateQuantity(List<Item> items) {
		return true;
	}
	public boolean updateInventory(List<Item> items) {
		return true;
	}

}
