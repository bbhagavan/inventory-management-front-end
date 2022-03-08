package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Vehicle implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Vehicle is initialized and ready to use..");		
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Vehicle is kept in garage..");
		
	}
	
}
