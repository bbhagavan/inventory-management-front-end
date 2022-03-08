package com.jms.controller;

import com.jms.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.web.bind.annotation.RestController
public class RestControllerClass {
	
	@Autowired
	private JmsTemplate template;
	
	@RequestMapping("send/{message}")
	public String sendMessage(@PathVariable String message) {
		try {
			template.convertAndSend("springbootQueue", message);
			return "Message sent!";
		} catch(Exception ex) {
			ex.printStackTrace();
			return "Error in sending message!";
		}
	}

	
	@RequestMapping(path="/sendCar", method = RequestMethod.POST, consumes = {"application/json"})
	public void sendCar(@RequestBody Car car){
		System.out.println("Sending Car details " + car);
		template.convertAndSend("springbootQueue", car);
	}
}

