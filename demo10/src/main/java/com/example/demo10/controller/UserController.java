package com.example.demo10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	private String tenco = "tenco";
	private String pass = "1234";
	
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "login.html";	// 내부에서 이동
	}
	
	/*
	 * 인증된 사용자만 들어올 수 있게 막을 예정
	 * AuthInterceptor 동작 시키려면 주소 설계를 /auth/**
	 */
	
	@GetMapping("/auth/infoPage")
	public String infoPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 테스트
//		HttpSession session = request.getSession();
//		Object principal = session.getAttribute("principal");
//		if(principal == null) {
//			// 인증된 사용자가 아님
//			return "redirect:/loginPage";
//		}
//		System.out.println("여기 코드 실행하려면 로그인 되어야 함");
		
		// 상대 위치 들어옴 -> 현재 그 시점에 맞게 설계 해야함
		// 여기 위치에서 상대경로로 찾을지 절대 경로로 찾을지 결정
		
		// -> http://localHost:8080/info.html	URL
		// -> http://localhost:8080/auth/info	URI
		// 새로운 request와 response 객체가 안들어간다.
		
		return "info.html";
	}
	
	// 세션에 값 넣어보기
	@PostMapping("/infoPage")
	public String middle(HttpServletRequest session) {
		
		session.setAttribute("tenco", tenco);
		session.setAttribute("pass", pass);
		
		System.out.println("11111111");
		
		return null;
	}
	
}// end of class
