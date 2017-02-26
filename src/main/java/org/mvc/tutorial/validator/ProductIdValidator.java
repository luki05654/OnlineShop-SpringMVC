package org.mvc.tutorial.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.mvc.tutorial.domain.Product;
import org.mvc.tutorial.domain.service.ProductService;
import org.mvc.tutorial.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
	@Autowired
	private ProductService productService;

	@Override
	public void initialize(ProductId arg0) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		Product product;
		try {
			product = productService.getProductById(value);
		} 
		catch (ProductNotFoundException e) {
			return true;
		}
		if (product != null) {
			return false;
		}
		return true;
	}

}