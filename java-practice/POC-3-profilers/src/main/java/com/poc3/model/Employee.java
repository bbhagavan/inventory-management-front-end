package com.poc3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String Id;
	private String Name;
	private String Gender;
	private Date dob;
	
	public Employee() {
		
	}
	
	public Employee(String Id, String Name, String Gender, Date dob) {
		this.Id = Id;
		this.Name = Name;
		this.Gender = Gender;
		this.dob = dob;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
