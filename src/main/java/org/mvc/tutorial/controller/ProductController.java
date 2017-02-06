package org.mvc.tutorial.controller;

import java.util.List;
import java.util.Map;

import org.mvc.tutorial.domain.service.ProductService;
import org.mvc.tutorial.views.ViewPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/" + ViewPages.PRODUCTS)
public class ProductController {
	private final static String PRODUCTS_KEY = "products";
	private static final String PRODUCT_KEY = "product";
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute(PRODUCTS_KEY, productService.getAllProducts());
		
		return ViewPages.PRODUCTS;
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute(PRODUCTS_KEY, productService.getProductsByCategory(productCategory));
		
		return ViewPages.PRODUCTS;
	}
	
	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute(PRODUCTS_KEY, productService.getAllProducts());
		
		return ViewPages.PRODUCTS;
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		
		return ViewPages.PRODUCTS;
	}
	
	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") String productId) {
		model.addAttribute(PRODUCT_KEY, productService.getProductById(productId));
		
		return ViewPages.PRODUCT;
	}
	
	@RequestMapping("/{category}/{price}")
	public String getByAdvancedFilter(Model model, 
			@PathVariable("category") String category,
			@MatrixVariable(pathVar="price") Map<String, String> priceFilter,
			@RequestParam("manufacturer") String manufacturer) {
		
		model.addAttribute(PRODUCTS_KEY, productService.getProductsByCategoryPriceScopeAndManufacturer(category, priceFilter, manufacturer));
		
		return ViewPages.PRODUCTS;
	}
}
