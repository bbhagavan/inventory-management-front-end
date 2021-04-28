package com.inventory.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="orders")
public class Order {

	@Id
	private int id;
	@Convert(converter = ListConverter.class)
	private WrapperItems items;
	private String address;
	private String status;
	
	public Order() {}
	
	public Order(int id, WrapperItems items, String address, String status) {
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
	public WrapperItems getItems() {
		return items;
	}
	public void setItems(WrapperItems items) {
		
		this.items = items;

		System.out.println("List");
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
