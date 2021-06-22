package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_product_map")
public class OrderProductMap {
	@Id
	private int order_id;
	private String product;
	private int count;
	
	public OrderProductMap() {}
	
	public OrderProductMap(int orderId, String product, int count) {
		this.order_id = orderId;
		this.product = product;
		this.count = count;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
//	public String toString() {
//		
//	}
}
