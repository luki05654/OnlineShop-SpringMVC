package org.mvc.tutorial.domain.repository;

import java.util.List;

import org.mvc.tutorial.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
