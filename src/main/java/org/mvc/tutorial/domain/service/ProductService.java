package org.mvc.tutorial.domain.service;

import java.util.List;

import org.mvc.tutorial.domain.Product;
import org.springframework.stereotype.Service;

public interface ProductService {
	List<Product> getAllProducts();
}
