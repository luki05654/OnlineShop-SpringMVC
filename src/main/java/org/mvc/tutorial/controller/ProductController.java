package org.mvc.tutorial.controller;

import java.math.BigDecimal;

import org.mvc.tutorial.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	private final static String PRODUCT = "product";
	
	@RequestMapping("/products")
	public String list(Model model) {
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription(
				"Apple iPhone 5s, smartfon z 4-calowym wyświetlaczem o rozdzielczości 640x1136 oraz 8-megapikselowym aparatem");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);

		model.addAttribute(PRODUCT, iphone);
		
		return "products";
	}
}
