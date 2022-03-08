package com.inventory.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private String userName;
	private String password;
	private boolean active;
	
	public MyUserDetails() {
	}
	
	public MyUserDetails(User user) {
		this.userName = user.getName();
		this.password = user.getPassword();
		this.active = user.isActive();

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return this.active;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return this.active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return this.active;
	}

	@Override
	public boolean isEnabled() {
		
		return this.active;
	}

}
