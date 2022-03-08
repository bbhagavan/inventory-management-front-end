package com.jms;

import java.io.Serializable;

public class Car implements Serializable{
	
	String make;
	String model;
	int price;
	
	public Car() {
		
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "Car{"+
				"make="+ make +
				", model= " + model +
				", has price= " + price +"}";
	}
}
