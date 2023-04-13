package com.example.demo9.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	// HandlerInterceptor 메서드 다 안써줘도 오류안나는 이유 Default로 구현해서

	// myInfo 이동시 세션여부를 확인 (controller 들어가기전에 가로채기)

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		// 설계예정
		// 사용자가 로그인하면 세션 메모리 영역에 user key=value 구조로 저장 처리 할 예정
		// getAttribute에 user라는 키값이 있니없니
		Object user = session.getAttribute("user");

		System.out.println("preHandler 동작 확인");

		if (user == null) {
			// 로그인 안한 사용자
			response.sendRedirect("/login-page");
			return false;
		}
		return true;
	}

}
