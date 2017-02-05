package org.mvc.tutorial.domain.impl;

import java.util.List;

import org.mvc.tutorial.domain.Customer;
import org.mvc.tutorial.domain.repository.CustomerRepository;
import org.mvc.tutorial.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
