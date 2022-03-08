package com.poc1.restAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String register() {
		return "home.jsp";
	}
		
	
}
