package com.inventory.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	private String role;
	
	public Role() {}
	
	public Role(@NotNull String name, String role) {
		this.id = id;
		this.name = name;
	}
	
	}
