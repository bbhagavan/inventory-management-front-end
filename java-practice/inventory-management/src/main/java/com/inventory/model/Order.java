package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="orders")
public class Order {

	@Id
	private int id;
	private String address;
	private String status;
	
	public Order() {}
	
	public Order(int id, String address, String status) {
		super();
		this.id = id;
		this.address = address;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
