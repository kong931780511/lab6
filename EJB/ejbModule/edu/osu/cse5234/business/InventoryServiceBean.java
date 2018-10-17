package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public static final String MY_QUERY = "Select i from Item i";
    @PersistenceContext
    EntityManager entityManager;
    public Inventory getAvailableInventory() {
		//ArrayList<Item> items = new ArrayList<>();
    	List<Item> items= entityManager.createQuery(MY_QUERY, Item.class).getResultList();  
		Inventory inventory=new Inventory();
		inventory.setItems(items);
		return inventory;
	}
	public boolean validateQuantity(List<Item> items) {
		return true;
	}
	public boolean updateInventory(List<Item> items) {
		return true;
	}

}
