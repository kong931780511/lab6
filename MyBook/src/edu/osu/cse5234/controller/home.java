package edu.osu.cse5234.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.Order;

@Controller
@RequestMapping("/")
public class home {
	@RequestMapping(method=RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		Order order = new Order();
//		ArrayList<Item> items = new ArrayList<>();
//		items.add(new Item("CPP", "80", "0"));
//		items.add(new Item("Python", "70", "0"));
//		items.add(new Item("Java", "60", "0"));
//		items.add(new Item("JS", "20", "0"));
//		items.add(new Item("HTML", "10", "0"));
//		order.setItems(items);
//		request.setAttribute("order", order);
		return "home";
	}
	
	@RequestMapping("/ContactUs")
	public String contact(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "ContactUs";
	}

	@RequestMapping("/AboutUs")
	public String about(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "AboutUs";
	}
}
