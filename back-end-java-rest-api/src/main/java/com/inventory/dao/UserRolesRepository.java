package com.inventory.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inventory.model.Role;

public interface UserRolesRepository extends CrudRepository<Role, Long>{
	Optional<Role> findByName(String username);
	
}