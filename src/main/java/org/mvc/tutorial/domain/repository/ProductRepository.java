package org.mvc.tutorial.domain.repository;

import java.util.List;

import org.mvc.tutorial.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
}
