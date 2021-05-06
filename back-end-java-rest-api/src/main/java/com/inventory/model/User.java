package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inventory.dao.DatabaseService;
import com.sun.istack.NotNull;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String mobile;
	@NotNull
	private String password;
	private long role;
	
	public User() {}
	
	public User(long id, String name, String email, String mobile, String password, long role) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}
	
	public boolean isActive() {
		return true;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		
		this.role = role;
	}
	public String toString() {
		return "User name: "+ this.getName()
			+"password: "+this.getPassword();
	}
}
