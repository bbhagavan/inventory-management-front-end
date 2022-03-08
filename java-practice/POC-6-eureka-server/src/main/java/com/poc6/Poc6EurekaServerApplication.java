package com.poc6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Poc6EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc6EurekaServerApplication.class, args);
	}

}
