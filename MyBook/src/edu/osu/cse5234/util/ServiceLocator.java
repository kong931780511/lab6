package edu.osu.cse5234.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.osu.cse5234.business.OrderProcessingServiceBean;
import edu.osu.cse5234.business.view.InventoryService;

public class ServiceLocator {

	public ServiceLocator() {
		// TODO Auto-generated constructor stub
	}

	public static InventoryService InventoryService() {
		try {
	         return (InventoryService) InitialContext.doLookup(
					"java:global/MyBook-InventoryManagement-EJBEAR/MyBook-InventoryManagement-EJB/InventoryServiceBean!edu.osu.cse5234.business.view.InventoryService");
		} catch (NamingException ne) {
				throw new RuntimeException(ne);
		}
	}
	
	public static OrderProcessingServiceBean getOrderProcessingService() {
		try {
			return (OrderProcessingServiceBean) InitialContext.doLookup("java:module/OrderProcessingServiceBean!edu.osu.cse5234.business.OrderProcessingServiceBean");
		} catch (NamingException ne) {
			throw new RuntimeException(ne);
		}
	}

}
