package org.mvc.tutorial.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {

	@Override
	public void initialize(Category arg0) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		switch (value.toLowerCase()) {
		case "tablet":
			return true;
			
		case "telefon":
			return true;
			
		case "laptop":
			return true;

		default:
			return false;
		}
	}

}
