package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	private String pid;
	private String name;
	private String desc;
	private int price;
		
	public Products() {
		
	}
	
	public Products(String pid, String name, String desc, int price, int count) {
		this.pid = pid;
		this.name = name;
		this.desc = desc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
