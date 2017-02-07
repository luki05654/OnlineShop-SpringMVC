package org.mvc.tutorial.domain.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mvc.tutorial.domain.Product;
import org.mvc.tutorial.domain.repository.ProductRepository;
import org.mvc.tutorial.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {		
		return productRepository.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public List<Product> getProductsByCategoryPriceScopeAndManufacturer(String category, Map<String, String> priceFilter, String manufacturer) {
		return productRepository.getProductsByCategoryPriceScopeAndManufacturer(category, priceFilter, manufacturer);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

}
