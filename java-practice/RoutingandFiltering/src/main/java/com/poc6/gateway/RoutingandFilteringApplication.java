package com.poc6.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

@SpringBootApplication
public class RoutingandFilteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingandFilteringApplication.class, args);
	}

//	@Bean
//	public ServerCodecConfigurer serverCodecConfigurer() {
//	   return ServerCodecConfigurer.create();
//	}
}
