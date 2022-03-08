package com.media.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.media.model.User;

@RestController
public class Controller {

	@RequestMapping("home")
	public String renderHomepage() {
		return "Welcome to Home page";
	}
	
	@RequestMapping(name="create", method=RequestMethod.POST)
	public String createPost() {
		return "Success or fail";
	}
	
	@PostMapping("login")
	public String login(@RequestParam User user) {
		return "token";
	}
}
