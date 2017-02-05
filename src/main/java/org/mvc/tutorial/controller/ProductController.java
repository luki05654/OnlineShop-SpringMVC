package org.mvc.tutorial.controller;

import java.math.BigDecimal;

import org.mvc.tutorial.domain.Product;
import org.mvc.tutorial.domain.repository.ProductRepository;
import org.mvc.tutorial.views.ViewPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	private final static String PRODUCTS = "products";
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/products")
	public String list(Model model) {

		model.addAttribute(PRODUCTS, productRepository.getAllProducts());
		
		return ViewPages.PRODUCTS;
	}
}
