package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BeanExampleApplication {

	@Autowired
	Vehicle veh, s1;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BeanExampleApplication.class, args);
		
		ApplicationContext cap = new ClassPathXmlApplicationContext("spring.xml");
		
		
		
		// Simulating the application behavior
		System.out.println("---Application code starts");
		
		Thread.sleep(5000L);
		
		System.out.println("---Application code ends");
		
//		new BeanExampleApplication().dothis();
		
		((ConfigurableApplicationContext) cap).close();
		
	}
	public void dothis() throws Exception {
		veh.destroy();
	}

}
