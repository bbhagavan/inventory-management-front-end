package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class SimpleScheduler {
	private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 3000)
	public void schedulerLookup() throws InterruptedException{
		System.out.println("Time is: " + format.format(new Date()) );
		Thread.sleep(5000);
	}
}
