package org.mvc.tutorial.controller;

import org.mvc.tutorial.domain.service.CustomerService;
import org.mvc.tutorial.views.ViewPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	private final static String CUSTOMERS_KEY = "customers";
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/" + ViewPages.CUSTOMERS)
	public String list(Model model) {
		model.addAttribute(CUSTOMERS_KEY, customerService.getAllCustomers());
		
		return ViewPages.CUSTOMERS;
	}
}
