package com.example.demo10.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 인터셉터를 등록할 클래스
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired	// DI 적용
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 규칙
		// 주소요청이 /auth/** 이 붙으면 AuthInterceptor
		// 동작하도록 구현 처리
		registry.addInterceptor(authInterceptor).addPathPatterns("/auth/**");
		
	}
	
}// end of class
