package com.example.demo8.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestWebMvcConfig implements WebMvcConfigurer{
	@Autowired
	
	private TestLoggingInterceptor testLoggingInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(testLoggingInterceptor);
		
	}
	
}
