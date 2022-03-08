package com.poc6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc6.model.Rating;
import com.poc6.model.UserRating;

@RestController
public class RatingController {

	@Autowired
	private JdbcTemplate template;
	
	@RequestMapping("/ratings/{userId}")
	public UserRating getRatings( @PathVariable String userId) {
		
		List<Rating> ratings = template.query(
					"select * from ratings where userId=" + userId, 
					new BeanPropertyRowMapper<Rating>(Rating.class)
				);
		UserRating user = new UserRating();
		user.setUserRatings(ratings);
		
		return user;
	}
}
