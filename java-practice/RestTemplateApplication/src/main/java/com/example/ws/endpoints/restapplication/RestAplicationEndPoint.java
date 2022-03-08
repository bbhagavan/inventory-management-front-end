package com.example.ws.endpoints.restapplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestAplicationEndPoint {
	private RestTemplate template;
	
	public RestAplicationEndPoint(RestTemplate template) {
		this.template = template;
	}
	
	@RequestMapping("/template")
	public String home() {
		String message = this.template.getForObject("http://localhost:8090", String.class);
		return message;
	}
}
