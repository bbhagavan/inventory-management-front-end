package com.example.demo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private String id;
	private String name;
	private String gender;
	private Date dob;
	
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
	public java.util.Date getDob() {
		return new java.util.Date(dob.getTime()) ;
	}
	public void setDob(String dob) {
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(dob));
			this.dob = new Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
