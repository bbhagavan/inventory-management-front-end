package com.example.ws.endpoint.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndPoint {
	
	@RequestMapping("/")
	public String out() {
		return "Hello world! this the message from the rest and at the port 8090";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Hello world! this the message from the rest and at the port 8090 \n we are at the home page..";
	}
}
