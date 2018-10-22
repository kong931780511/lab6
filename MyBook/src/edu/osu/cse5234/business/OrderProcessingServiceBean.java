package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;
import edu.osu.cse5234.business.view.Item;


/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	@PersistenceContext
	EntityManager entityManager;
	
	public static final String MY_QUERY = "Select i from Item i";
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService invService = ServiceLocator.InventoryService();
    	invService.validateQuantity(lineItemsToItems(order.getLineItems()));
    	invService.updateInventory(lineItemsToItems(order.getLineItems()));
    	entityManager.persist(order);
    	entityManager.flush();
    	return new Random().nextInt(1000000) + "";
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.InventoryService().validateQuantity(lineItemsToItems(order.getLineItems()));
    }
    
    private List<Item> lineItemsToItems(List<LineItem> lineItems) {
    	List<Item> items = new ArrayList<Item>();
    	for(LineItem li : lineItems) {
    		Item i = new Item();
    		i.setName(li.getItemName());
    		i.setNumber(li.getItemNumber());
    		i.setAvailableQuantity(li.getQuantity());
    		i.setUnitPrice(li.getPrice());
    		items.add(i);
    	}
    	return items;
    }
    
}
