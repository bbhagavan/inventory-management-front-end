package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	private String pid;
	private String name;
	private String description;
	private int price;
	private int discount;
		
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Products() {
		
	}
	
	public Products(String pid, String name, String description, int price, int count) {
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
