package org.mvc.tutorial.validator;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.mvc.tutorial.domain.Product;

@Component
public class UnitsInStockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getUnitPrice() != null && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0
				&& product.getUnitsInStock() > 99) {
			errors.rejectValue("unitsInStock", "org.mvc.tutorial.validator.UnitsInStockValidator.message");
		}
	}

}
