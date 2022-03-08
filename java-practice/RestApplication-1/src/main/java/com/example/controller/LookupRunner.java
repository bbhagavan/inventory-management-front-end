package com.example.controller;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.service.LookupService;

@Component
public class LookupRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(LookupRunner.class);
	
	@Autowired
	private LookupService service;
	
	public void run(String... args) throws Exception {
		CompletableFuture<User> info1 = service.findUser("Pytorch");
		CompletableFuture<User> info2 = service.findUser("Tensorflow");
		CompletableFuture<User> info3 = service.findUser("Scikit-learn");
		CompletableFuture<User> info4 = service.findUser("spring-mvc");
		CompletableFuture<User> info5 = service.findUser("spring-boot");
		CompletableFuture<User> info6 = service.findUser("spring-security");
		
		CompletableFuture.allOf(info1, info2, info3, info4, info5, info6).join();
		
		logger.info("---> "+info1.get());
		logger.info("---> "+info2.get());
		logger.info("---> "+info3.get());
		logger.info("---> "+info4.get());
		logger.info("---> "+info5.get());
		logger.info("---> "+info6.get());
	}
}
