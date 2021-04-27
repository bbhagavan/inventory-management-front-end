package com.inventory.model;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="orders")
public class Order {

	@Id
	private int id;
	@Convert(converter = ListConverter.class)
	private List<String> items;
	private String address;
	private String status;
	
	public Order() {}
	
	public Order(int id, List<String> items, String address, String status) {
		super();
		this.id = id;
		this.items = items;
		this.address = address;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
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
