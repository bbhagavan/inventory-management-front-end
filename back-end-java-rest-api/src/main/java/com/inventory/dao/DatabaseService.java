package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.inventory.model.Cart;
import com.inventory.model.CartItem;
import com.inventory.model.Order;
import com.inventory.model.Products;

@Service
public class DatabaseService {
	@Autowired
	public RepoForProducts repo;
	@Autowired
	public RepoForCart cartRepo;
	@Autowired
	public RepoForOrder orderRepo;
	@Autowired
	public UserRepository userRepo;
	@Autowired
	public UserRolesRepository roleRepo;
	
	public List<Products> getProducts() {
		
		return (List<Products>) repo.findAll();
	}
	
	public List<Order> getOrders() {
		
		return (List<Order>) orderRepo.findAll();
	}
	
	public String postOrder(Order order) {
		
		Order result = orderRepo.save(order);
				
		if(result==order)
			return "Success";
		return "Faild";
	}
	
	public List<CartItem> getOrderDetails(int id) {
		
		Order order = orderRepo.findById(id).orElse(new Order());
				 
		 return (List<CartItem>) order.getItems().getProducts()
				 .stream()
				 .map((Cart item) -> {
					 return  new CartItem(
							 repo.findById(item.getPid()).orElse(new Products()),
							 	item.getCount()
							 );
					 }).collect(Collectors.toList());
			
	}
	
	public List<CartItem> getCart() {
		
		List<Cart> items = new ArrayList<Cart>();
		items =(List<Cart>) cartRepo.findAll();
				
		return (List<CartItem>) items.stream()
				  .map(item -> {  
					  Products prod = repo.findById(item.getPid()).orElse(new Products());
					  return new CartItem(prod, item.getCount());
				  }).collect(Collectors.toList());
	}	
	
	public String postIntoCart(Products item) {
		
		Cart result = cartRepo.findById(item.getPid()).orElse(new Cart());
		
		if( result!= null) {
			
			cartRepo.save(new Cart(item.getPid(),result.getCount()+1));
			return "updated";
		}
		
		cartRepo.save(new Cart(item.getPid(),1));
		return "success";
	}
	
	public String deleteCartItems() {
		
		cartRepo.deleteAll();
		return "Deleted";	
	}
	
	public String removeCartItem(String id) {
		
		cartRepo.deleteById(id);
		return "Deleted";	
	}

//	public String addRoles() {
//		roleRepo.save(new Role("Ram", "ADMIN"));
//		userRepo.save(new User());
//		return "Done";
//	}
//	public Role findRole(long id) {
//		return roleRepo.findById(id).orElse(new Role());
//	}
}


interface RepoForProducts extends CrudRepository<Products, String>{
	@Query("from products")
	
	
}

interface RepoForCart extends JpaRepository<Cart, String>{

}

interface RepoForOrder extends CrudRepository<Order, Integer>{
	
}