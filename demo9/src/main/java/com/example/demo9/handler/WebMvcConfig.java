package com.example.demo9.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired // DI 처리
	private AuthInterceptor authInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 야 authInterceptor 동작 시킬 때 모든 페이지를
		// 니가 가로채면 무조건 리다이렉트 되잖아 !!!
		// 그게아니라 내가 명시하는 요청 설계 주소에서만 동작 하도록
		// 일 하겠니?

		// http:localhost:8080/hello <- 인터셉터 동작하지 않음
		// http:localhost:8080/myPage/myInfo <- 인터셉터 동작 함
		registry.addInterceptor(authInterceptor).addPathPatterns("/myPage/**");
	}

}
