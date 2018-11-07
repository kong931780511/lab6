package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;
import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.util.ServiceLocator;
import edu.osu.cse5234.business.view.Item;


@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class) 

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;
	
	@Resource(lookup="jms/emailQ")
	private Queue queue;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@WebServiceRef(wsdlLocation="http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;
	
	public static final String MY_QUERY = "Select i from Item i";
	
	private static String shippingResourcesURI = "http://localhost:9080/UPS/jaxrs";
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	PaymentInfo paymentInfo = order.getPaymentInfo();
    	CreditCardPayment ccPayment = paymentInfoToCreditCardPayment(paymentInfo);
    	String confirmation = service.getPaymentProcessorPort().processPayment(ccPayment);
    	int confNum = Integer.parseInt(confirmation);
    	if(confNum < 0) {
    		// Abandon Processing
    		return confirmation;
    	} else {
	    	InventoryService invService = ServiceLocator.InventoryService();
	    	invService.validateQuantity(lineItemsToItems(order.getLineItems()));
	    	invService.updateInventory(lineItemsToItems(order.getLineItems()));
	    	order.getPaymentInfo().setConfirmationNumber(confirmation);
	    	entityManager.persist(order);
	    	entityManager.flush();
	    	notifyUser(order.getEmailAddress());
	    	ShippingInitiationClient client = new ShippingInitiationClient(shippingResourcesURI);
	    	JsonObject requestJson = Json.createObjectBuilder()
	    			.add("Organization", "MyBook")
	    			.add("OrderRefId", order.getId())
	    			.add("Zip", order.getShippingInfo().getZip())
	    			.add("ItemsNumber", order.getLineItems().size())
	    			.build();
	    	JsonObject responseJson = client.invokeInitiateShipping(requestJson);
	    	System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
	    	System.out.println("Shipping Reference Number: " +  responseJson.getInt("ShippingReferenceNumber"));
	    	return confirmation;
    	}
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.InventoryService().validateQuantity(lineItemsToItems(order.getLineItems()));
    }
    
    private void notifyUser(String customerEmail) {
    	String message = customerEmail + ":" +
    	       "Your order was successfully submitted. " + 
    	      "You will hear from us when items are shipped. " + 
    	       new Date();
    	System.out.println("Sending message: " + message);
    	jmsContext.createProducer().send(queue, message);
    	System.out.println("Message Sent!");
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
    
    private CreditCardPayment paymentInfoToCreditCardPayment(PaymentInfo paymentInfo) {
    	CreditCardPayment ccPayment = new CreditCardPayment();
    	ccPayment.setId(paymentInfo.getId());
    	ccPayment.setCardHolderName(paymentInfo.getCardHolderName());
    	ccPayment.setCreditCardNumber(paymentInfo.getCreditCardNumber());
    	ccPayment.setCvvCode(paymentInfo.getCvvCode());
    	ccPayment.setExpirationDate(paymentInfo.getExpirationDate());
    	return ccPayment;
    }
}
