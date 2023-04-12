package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller		// 페이지
public class UserController {

	// 주소설계 둘다 가능
	// http://localhost:8080/user
	// http://localhost:8080/
	// 페이지 리턴할 때는 String 쓸거임
	@GetMapping({"/", "user"})	// 주소 여러개 설정
	public String userPage(Model model) {
		
		// prefix: /WEB-INF/view/user.jsp
		// suffix: .jsp
		
		// WEB-INF/view/user.jsp 가 완성됨 (yml파일에서 설정)
		// viewResolver가 동작해서 페이지를 찾고 리턴
		
		// 데이터를 내려보내고 싶다면 public String userPage(Model model) { 선언
		model.addAttribute("principal", "hello");
		return "user";
	}
	
} // end of class
