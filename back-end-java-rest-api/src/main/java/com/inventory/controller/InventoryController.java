package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/orders")
	public List<Order> getOrders() {
					
		return (List<Order>) orderRepo.findAll();
	}
	
	@PostMapping("/orders")
	public String postOrders(@RequestBody Order order) {
		System.out.println("came: order id:"+order.getId()+"=>items: "+order.getItems());
		
		
		Order result = orderRepo.save(order);
		
		
		if(result==order)
			return "Success";
		return "Faild";
	}
	
	@RequestMapping("/ordersdetails/{id}")
	public List<CartItem> getOrderDetails(@PathVariable int id) {
		
		Order order = orderRepo.findById(id).orElse(new Order());
		
//		List<CartItem> result = new ArrayList<>();
//		Map<String, Integer> map = order.getItems();
//		 for(String pid:map.keySet() ) {
//				result.add(new CartItem((Products)repo.findById(pid).orElse(new Products()),map.get(pid)));
//			}
		 
		 return (List<CartItem>) order.getItems().getProducts()
				 .stream()
				 .map((Cart item) -> {
					 return  new CartItem(
							 	repo.findById(item.getPid()).orElse(new Products()),
							 	item.getCount()
							 );
					 }).collect(Collectors.toList());
			
	}
	
	@GetMapping("/cart")
	public List<CartItem> getCart() {
		
		List<Cart> items = new ArrayList<Cart>();
		items =(List<Cart>) cartRepo.findAll();
				
		return (List<CartItem>) items.stream()
				  .map(item -> {  
					  Products prod = repo.findById(item.getPid()).orElse(new Products());
					  return new CartItem(prod, item.getCount());
				  }).collect(Collectors.toList());
	}	
	
	@RequestMapping(value="/cart",method = RequestMethod.POST)
	public String postIntoCart(@RequestBody Products item) {
		
		Cart result =cartRepo.findById(item.getPid()).orElse(new Cart());
		
		if( result!= null) {
			
			cartRepo.save(new Cart(item.getPid(),result.getCount()+1));
			return "updated";
		}
		
		 cartRepo.save(new Cart(item.getPid(),1));
		return "success";
		
	}
	@RequestMapping(value="/cart",method = RequestMethod.DELETE)
	public String deleteCartItems() {
		
		cartRepo.deleteAll();
		return "Deleted";
		
	}
	
	@RequestMapping(value="/cart/{id}",method = RequestMethod.DELETE)
	public String removeCartItem(@PathVariable String id) {
		
		cartRepo.deleteById(id);
		return "Deleted";
		
	}
}

interface RepoForProducts extends CrudRepository<Products, String>{
	
}
interface RepoForCart extends JpaRepository<Cart, String>{

}
interface RepoForOrder extends CrudRepository<Order, Integer>{
	
}