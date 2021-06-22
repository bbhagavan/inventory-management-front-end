package com.inventory.model;

public class CartItem {

	private String pid;
	private String name;
	private String description;
	private int price;
	private int discount;
	private int count;
	
	public CartItem() {}
	public CartItem(String pid, String name, String description, int price, int discount, int count) {
		this.count = count;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.pid = pid;
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
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
