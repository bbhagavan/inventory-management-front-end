package com.poc5.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private String id;
	private String name;
	private String gender;
	private Date dob;
	
	public Employee(String id, String name, String gender, Date dob) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}
	public Employee() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(String dob) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.dob = dateFormat.parse(dob);
	}
	public String toString() {
		return "{ id: " + this.id 
				 	+ ", name: " + this.name 
				 	+ ", gender: " + this.gender
				 	+ ", dob: " + this.dob + " }";
	}
	
}
