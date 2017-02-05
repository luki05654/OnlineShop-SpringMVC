package org.mvc.tutorial.domain.impl;

import java.util.ArrayList;
import java.util.List;

import org.mvc.tutorial.domain.Customer;
import org.mvc.tutorial.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	private List<Customer> listOfCustomers = new ArrayList<>();

	public InMemoryCustomerRepository() {
		Customer customer1 = new Customer("C1", "Jan Kowalski");
		customer1.setAddress("Al. Tysi¹clecia 2");

		Customer customer2 = new Customer("C2", "Robert Nowak");
		customer2.setAddress("Liniak 2");

		Customer customer3 = new Customer("C3", "Joanna Lisiecka");
		customer3.setAddress("Konopnica 231");

		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
		listOfCustomers.add(customer3);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

}
