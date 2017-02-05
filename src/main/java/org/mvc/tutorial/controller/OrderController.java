package org.mvc.tutorial.controller;

import org.mvc.tutorial.domain.service.OrderService;
import org.mvc.tutorial.views.ViewPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/P1234/2")
	public String process() {
		orderService.processOrder("P1234", 2);
		
		return "redirect:/" + ViewPages.PRODUCTS;
	}
}
