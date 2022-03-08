package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Car {

	@PostConstruct
	public void initialMethod() {
		System.out.println("Car bean is initialized..");
	}
	
	@PreDestroy
	public void destroyMethod() {

		System.out.println("Car bean is Distroyed..");
	}
}
