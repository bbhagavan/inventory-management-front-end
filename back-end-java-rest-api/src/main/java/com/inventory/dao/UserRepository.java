package com.inventory.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inventory.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByName(String username);

}
