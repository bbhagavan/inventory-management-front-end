package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.InterceptorExample;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer{
	@Autowired
	private InterceptorExample interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor);
	}
	
}
