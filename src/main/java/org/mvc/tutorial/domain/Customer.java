package org.mvc.tutorial.domain;

public class Customer {
	private String consumerId;
	private String name;
	private String address;
	private int noOfOrdersMade;

	/**
	 * @param consumerId
	 * @param name
	 */
	public Customer(String consumerId, String name) {
		super();
		this.consumerId = consumerId;
		this.name = name;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(int noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

}
