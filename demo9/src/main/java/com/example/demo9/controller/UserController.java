package com.example.demo9.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo9.dto.User;

@Controller
public class UserController {

	// 확장자가 있으면 URL 방식 없으면 URI 방식
	// 1. 로그인 페이지를 직접 URL 요청해서 응답 받을 수 있다.(사전지식)
	// 2. 로그인 페이지를 controller를 타서 응답처리 해보자.
	@GetMapping("/login-page")
	public String login() {
		// 이녀석 IoC해줘야함
		// IoC : 컨테이너 객체에 이녀석을 new 때리게 해주는것
		return "login.html";
	}

	// myinfo 설계
	// http:localhost:8080/myInfo-page <- 설계해야 인터페이스 동작 됨
	@GetMapping("/myInfo-page")
	public String myInfo() {
		// 인증이 필요한 페이지로 만들기로 함
		return "myPage/myInfo.html";
	}

	@GetMapping("/cart-page")
	public String cart() {

		return "myPage/cart.html";
	}

	// MYIME TYPE = form : x--
	// @RequestBody <- application/json
	@PostMapping("/login-proc")
	public String loginProc(HttpServletRequest request, User user) {
		// 로직(세션 저장 후 myInfo 페이지 이동 처리)
		HttpSession session = request.getSession();
		System.out.println("user : " + user);
		session.setAttribute("user", user);

		// response.sendRedirect("/myPage/myInfo.html");
		// 위아래 같은 코드
		return "redirect:/myPage/myInfo.html";
	}

	@PostMapping("/login-cart")
	public String loginCart(HttpServletRequest request, HttpServletResponse response, User user) {

		HttpSession session = request.getSession();

		session.setAttribute("user", user);

		return "redirect:/myPage/cart.html";
	}

} // end of class
