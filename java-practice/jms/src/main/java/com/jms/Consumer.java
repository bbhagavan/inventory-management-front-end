package com.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements MessageListener {
	
	private Logger log= LoggerFactory.getLogger(Consumer.class);
	
	public void onMessage(Message msg) {
		try {
			log.info("Received message: " + msg.getBody(Object.class));
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}
}
