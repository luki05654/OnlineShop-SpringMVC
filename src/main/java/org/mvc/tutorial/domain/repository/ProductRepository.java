package org.mvc.tutorial.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mvc.tutorial.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();

	Product getProductById(String id);

	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

	List<Product> getProductsByCategoryPriceScopeAndManufacturer(String category, Map<String, String> priceFilter, String manufacturer);
}
