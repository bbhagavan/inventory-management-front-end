package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.JwtUtil;
import com.inventory.MyUserDetailsService;
import com.inventory.dao.DatabaseService;
import com.inventory.model.AuthenticationRequest;
import com.inventory.model.AuthenticationResponse;
import com.inventory.model.CartItem;
import com.inventory.model.MyUserDetails;
import com.inventory.model.Order;
import com.inventory.model.Products;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class InventoryController {
	
	@Autowired
	DatabaseService service;

	@RequestMapping("/products")
	public List<Products> getMeProducts() {
		
		return service.getProducts();
	}
	
	@GetMapping("/orders")
	public List<Order> getMeOrders() {
					
		return service.getOrders();
	}
	
	@PostMapping("/orders")
	public String postOrders(@RequestBody Order order) {
				
		return service.postOrder(order);
	}
	
	@RequestMapping("/ordersdetails/{id}")
	public List<CartItem> getMeOrderDetails(@PathVariable int id) {
		
		return service.getOrderDetails(id);
	}
	
	@GetMapping("/cart")
	public List<CartItem> getMeCart() {
						
		return service.getCart();
	}	
	
	@RequestMapping(value="/cart",method = RequestMethod.POST)
	public String postIntoCart(@RequestBody Products item) {
		
		return service.postIntoCart(item);		
	}
	
	@RequestMapping(value="/cart",method = RequestMethod.DELETE)
	public String deleteCartItems() {
		
		return service.deleteCartItems();
	}
	
	@RequestMapping(value="/cart/{id}",method = RequestMethod.DELETE)
	public String removeCartItem(@PathVariable String id) {
		
		return service.removeCartItem(id);	
	}
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService; 
	@Autowired
	private JwtUtil  jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> athenticate(@RequestBody AuthenticationRequest request) throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch(BadCredentialsException e) {
			throw new Exception("Incorrect username and password"+ e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
