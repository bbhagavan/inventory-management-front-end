package com.inventory.model;

public class CartItem {

	private Products item;
	private int count;
	
	public CartItem() {}
	public CartItem(Products item, int count) {
		this.item = item;
		this.count = count;
	}
	
	public Products getItem() {
		return item;
	}
	public void setItem(Products item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
