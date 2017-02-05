package org.mvc.tutorial.domain.impl;

import org.mvc.tutorial.domain.Product;
import org.mvc.tutorial.domain.repository.ProductRepository;
import org.mvc.tutorial.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void processOrder(String productId, int count) {
		Product productById = productRepository.getProductById(productId);

		if (productById.getUnitsInStock() < count) {
			throw new IllegalArgumentException(
					"Zbyt ma³o towaru. Obecna liczba sztuk w magazynie: " + productById.getUnitsInStock());
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

}
