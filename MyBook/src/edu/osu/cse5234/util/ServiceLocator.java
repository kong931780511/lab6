package edu.osu.cse5234.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.osu.cse5234.business.view.InventoryService;

public class ServiceLocator {

	public ServiceLocator() {
		// TODO Auto-generated constructor stub
	}

	public static InventoryService getInventoryService() {
		try {
	         return (InventoryService) InitialContext.doLookup(
	        		 "java:global/MyGolf-InventoryManagement-EJBEAR/MyBook-InventoryManagement-EJB/InventoryServiceBean!edu.osu.cse5234.business.view.InventoryService");
		} catch (NamingException ne) {
				throw new RuntimeException(ne);
		}

	}

}
