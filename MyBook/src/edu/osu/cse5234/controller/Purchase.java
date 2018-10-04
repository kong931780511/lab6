package edu.osu.cse5234.controller;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
			Order order = new Order();
			ArrayList<Item> items = new ArrayList<>();
			items.add(new Item("CPP", "80", "0"));
			items.add(new Item("Python", "70", "0"));
			items.add(new Item("Java", "60", "0"));
			items.add(new Item("JS", "20", "0"));
			items.add(new Item("HTML", "10", "0"));
			order.setItems(items);
			request.setAttribute("order", order);
			return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
//		System.out.println(paymentInfo.getCreditCardNumber());
		return "redirect:/purchase/shippingEntry";
	}
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shippingInfo", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShippingInfo(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
//		System.out.println(request.getSession().getAttribute("order"));
		return "redirect:/purchase/viewOrder";
	}
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("order", new PaymentInfo());	
//		System.out.println(request.getSession().getAttribute("order"));
		return "ViewOrder";
	}
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
//		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewConfirmation";
	}
	@RequestMapping(path="/viewConfirmation",method=RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request) {
		int num = new Random().nextInt(1000000);
		request.getSession().setAttribute("confirmNum", num+"");
		return "Confirmation";
	}
}