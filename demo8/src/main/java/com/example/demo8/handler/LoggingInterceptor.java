package com.example.demo8.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 인터셉터 만들기
 * 1. HandlerInterceptor 구현 처리
 * 2. 3가지 메서드 기억하기
 * ( , , )
 */
// 어노테이션 사용하지 않았음 !!!
// 이유 : 인터페이스를 만들 때 webMVC 만들어야함
@Component
public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		System.out.println("==========================");
//		System.out.println("Request URI : " + request.getRequestURI());
//		System.out.println("Reqeust Method : " + request.getMethod());

		// controller로 안가고 preHandle 메서드가 인터셉트함
//		return false;
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}// end of class
