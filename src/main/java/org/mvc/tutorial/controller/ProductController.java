package org.mvc.tutorial.controller;

import org.mvc.tutorial.domain.service.ProductService;
import org.mvc.tutorial.views.ViewPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	private final static String PRODUCTS = "products";
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String list(Model model) {

		model.addAttribute(PRODUCTS, productService.getAllProducts());
		
		return ViewPages.PRODUCTS;
	}
}
