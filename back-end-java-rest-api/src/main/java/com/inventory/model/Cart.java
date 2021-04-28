package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="cart")
public class Cart {

	@Id
	private String pid;
	private int count;
	
	public Cart() {}
	
	public Cart(String pid, int count) {
		this.pid = pid;
		this.count = count;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
