package com.inventory.model;

import java.util.List;

public class WholeOrder {

	private int id;
	private String address;
	private String status;
	private List<Cart> products;
	
	
	public WholeOrder() {
	}

	public WholeOrder(int id, String address, String status, List<Cart> products) {
		super();
		this.id = id;
		this.address = address;
		this.status = status;
		this.products = products;
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
	public List<Cart> getProducts() {
		return products;
	}
	public void setProducts(List<Cart> products) {
		this.products = products;
	}
	public String toString() {
		return "Whole order with order id: "+getId()+", address: "+getAddress()
			+", products: "+ getProducts();
	}
}
