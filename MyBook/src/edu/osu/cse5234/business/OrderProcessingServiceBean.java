package edu.osu.cse5234.business;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService invService = ServiceLocator.InventoryService();
    	invService.validateQuantity(order.getItems());
    	invService.updateInventory(order.getItems());
    	return new Random().nextInt(1000000) + "";
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.InventoryService().validateQuantity(order.getItems());
    }
}
