package com.poc6.catalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc6.catalog.model.Book;
import com.poc6.catalog.model.CatalogItem;
import com.poc6.catalog.model.UserRating;

@RestController
@RequestMapping("/user")
public class CatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getRatedBooks(@PathVariable String userId) {
		UserRating user = restTemplate.getForObject("http://BOOK-RATINGS-SERVICE/ratings/"+userId, UserRating.class);
		
		return user.getUserRatings().stream()
					.map( rating -> {
						Book book = restTemplate.getForObject("http://BOOK-INFO-SERVICE/book/"+rating.getBookId(), Book.class);
						return new CatalogItem(book.getTitle(), book.getAuthor(), rating.getRating());
					})
					.collect(Collectors.toList());
		
	}
}
