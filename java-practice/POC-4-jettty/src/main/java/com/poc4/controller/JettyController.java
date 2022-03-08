package com.poc4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JettyController {
	
	@RequestMapping("/")
	public String helloWorld() {
		return "Hello we are running in the jetty server.";
	}

}
