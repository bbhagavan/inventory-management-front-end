package com.poc6.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc6.info.model.Book;


@RestController
@RequestMapping("/book")
public class BooksController {
	
	@Autowired
	private JdbcTemplate template;

	@RequestMapping("/{bookId}")
	public Book getBookDetails(@PathVariable String bookId){
		List<Book> books = template.query(
				"select * from books where bookId=" + bookId, 
				new BeanPropertyRowMapper<Book>(Book.class)
			);
		return books.get(0);
	}
}
