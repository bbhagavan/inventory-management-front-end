package com.inventory.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.inventory.model.Cart;
import com.inventory.model.CartItem;
import com.inventory.model.Order;
import com.inventory.model.OrderProductMap;
import com.inventory.model.Products;
import com.inventory.model.WholeOrder;

@Service
public class DatabaseService {
	@Autowired
	private RepoForProducts repo;
	@Autowired
	private RepoForCart cartRepo;
	@Autowired
	private RepoForOrder orderRepo;
	@Autowired
	private RepoForMapping mapRepo;
	@Autowired
	private JdbcTemplate template;
	
	public List<Products> getProducts() {
		
		return (List<Products>) repo.findAll();
	}
	
	public List<Order> getOrders() {
		
		return (List<Order>) orderRepo.findAll();
	}
	
	public String postOrder(WholeOrder order) {
		
		orderRepo.save(new Order(order.getId(), order.getAddress(), order.getStatus()));
		
		order.getProducts().stream()
		.forEach((Cart item) -> {
			mapRepo.saveProduct(order.getId(), item.getProduct_id(), item.getCount());
		});
				
		return "Success";
	}
	
	public List<CartItem> getOrderDetails(int id) {
						 
		return template.query("select pid, name, description,price, discount, count from "
				+ "(SELECT product, count FROM order_product_map where order_id="+id+") as temp "
				+ " inner join products where temp.product=products.pid;",
				new BeanPropertyRowMapper<CartItem>(CartItem.class)
			); 			
	}
	
	public List<CartItem> getCart() {
		
		return template.query("select products.pid, name, description,price,discount, count from "
				+ "	(SELECT * FROM cart) as temp "
				+ "inner join products where temp.product_id=products.pid;",
				new BeanPropertyRowMapper<CartItem>(CartItem.class)
			);
	}	
	
	public String postIntoCart(Products item) {
		
		template.update("INSERT INTO cart VALUES (?,1) ON DUPLICATE KEY UPDATE count=count+1",
				item.getPid());
		return "success";
	}
	
	public String clearCart() {
		cartRepo.deleteTableContent();
		return "Deleted";	
	}
	
	public String removeCartItem(String id) {
		
		cartRepo.deleteById(id);
		return "Deleted";	
	}
	
	public String decreaseCartItem(String id) {
		template.update("update inventory.cart set count=count-1 where product_id = ?",id);
		return "Decreased count";
	}

}


interface RepoForProducts extends CrudRepository<Products, String>{
	@Query(value="select * from products", nativeQuery = true)
	public List<Products> getProducts();	
}

interface RepoForCart extends JpaRepository<Cart, String>{
	@Modifying
	@Query(value="truncate table inventory.cart", nativeQuery = true)
	@Transactional
	public void deleteTableContent();
}

interface RepoForMapping extends CrudRepository<OrderProductMap, Integer>{
	@Modifying
	@Query(value="insert into inventory.order_product_map values(:orderId, :product, :count)", nativeQuery = true)
	@Transactional
	public int saveProduct(@Param("orderId") int orderId, @Param("product") String product, @Param("count") int count);
}

interface RepoForOrder extends CrudRepository<Order, Integer>{
}