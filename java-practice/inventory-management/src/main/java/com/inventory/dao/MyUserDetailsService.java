package com.inventory.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inventory.model.MyUserDetails;
import com.inventory.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repo.findByName(username);
				
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));
		
		return user.map(MyUserDetails::new).get();
	}
	
	public void createUser(UserDetails user) { 
	      repo.save((User) user); 
	}
}
