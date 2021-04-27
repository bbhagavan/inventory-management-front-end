package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Cart;
import com.inventory.model.CartItem;
import com.inventory.model.Order;
import com.inventory.model.Products;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class InventoryController {
	
	@Autowired
	RepoForProducts repo;
	@Autowired
	RepoForCart cartRepo;
	@Autowired
	RepoForOrder orderRepo;

	@RequestMapping("/products")
	public List<Products> getProducts() {
		return (List<Products>) repo.findAll();
	}
	
	@RequestMapping("/orders")
	public List<Order> getOrders() {
					
		return (List<Order>) orderRepo.findAll();
	}
	
	@RequestMapping("/ordersdetails/{id}")
	public List<Products> getOrderDetails(@PathVariable int id) {
		
		Order order = orderRepo.findById(id).orElse(new Order());
		
		return (List<Products>) order.getItems()
				.stream()
				.map(item -> {
					return repo.findById(item).orElse(new Products());
					})
				.collect(Collectors.toList());		
	}
	
	@RequestMapping("/cart")
	public List<CartItem> getCart() {
		
		List<Cart> items = new ArrayList<Cart>();
		items =(List<Cart>) cartRepo.findAll();
				
		return (List<CartItem>) items.stream()
				  .map(item -> {  
					  Products prod = repo.findById(item.getPid()).orElse(new Products());
					  return new CartItem(prod, item.getCount());
				  }).collect(Collectors.toList());
	}	
}

interface RepoForProducts extends CrudRepository<Products, String>{
	
}
interface RepoForCart extends CrudRepository<Cart, String>{
	
}
interface RepoForOrder extends CrudRepository<Order, Integer>{
	
}