package org.mvc.tutorial.domain.impl;

import java.util.List;

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

}
