package com.example.demo8.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 1. WebMvcConfigurer 구현 처리 하기
 * 2. addInterceptors 구현 하기
 */

// 1개 이상 new 때릴 때 쓰는 어노테이션
// = 1개 이상 bean으로 등록해야 할 때
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	// DI를 사용하는 코드로 변경해 보자.
	@Autowired // 어노테이션 사용해서 DI 적용
	// @Autowired : 컨테이너에서 객체를 가져오는 것
	// 어노테이션을 안썼을 때 메모리에 안올라가있던 상태
	// 컨테이너에 안올라가있는데 땡겨올려고해서 동작하지않음
	// @Component를 쓰면 코드 자체를 객체로 만들어서 메모리에 올려줌
	private LoggingInterceptor loggingInterceptor;

//	public WebMvcConfig(LoggingInterceptor loggingInterceptor) {
//		this.loggingInterceptor = loggingInterceptor;
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 우리가 직접 만든 인터셉터 구현 클래스 등록하기
		registry.addInterceptor(loggingInterceptor);

//		WebMvcConfigurer.super.addInterceptors(registry); 이거 안쓸거임
	}

}// end of class
