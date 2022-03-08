package com.jms;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class MessageConfig {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Value("${myqueue}")
	private String queue;
	
	@Bean
	public DefaultMessageListenerContainer messageListerner() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(this.connectionFactory);
		container.setDestinationName(queue);
		container.setMessageListener(new Consumer());
	
		return container;
	}
}
