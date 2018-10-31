package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
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
    @WebServiceRef(wsdlLocation = 
    		"http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
    		private PaymentProcessorService service;
    
    public String processOrder(Order order, PaymentInfo paymentInfo) {
    	CreditCardPayment creditCardPayment = new CreditCardPayment();
    	creditCardPayment.setCardHolderName(paymentInfo.getCardHolderName());
    	creditCardPayment.setCreditCardNumber(paymentInfo.getCreditCardNumber());
    	creditCardPayment.setCvvCode(paymentInfo.getCvvCode());
    	creditCardPayment.setExpirationDate(paymentInfo.getExpirationDate());
    	creditCardPayment.setPaymentAmount(10);
    	String res = service.getPaymentProcessorPort().processPayment(creditCardPayment); 
    	if (Integer.parseInt(res) < 0) {
    		return "XXXXXXXX";
    	}
    	InventoryService invService = ServiceLocator.InventoryService();
    	invService.validateQuantity(lineItemsToItems(order.getLineItems()));
    	invService.updateInventory(lineItemsToItems(order.getLineItems()));
    	String confirmNum = new Random().nextInt(1000000) + "";
    	paymentInfo.setConfirmationNumber(confirmNum);
    	order.setPaymentInfo(paymentInfo);
    	entityManager.persist(order);
    	entityManager.flush();
    	return confirmNum;
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
