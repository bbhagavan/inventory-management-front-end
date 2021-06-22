package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="cart")
public class Cart {

	@Id
	private String product_id;
	private int count;
	
	public Cart() {}
	
	public Cart(String pid, int count) {
		this.product_id = pid;
		this.count = count;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setPid(String pid) {
		this.product_id = pid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String toString() {
		return "Id: " + getProduct_id() + ", count: " + getCount();
	}
}
