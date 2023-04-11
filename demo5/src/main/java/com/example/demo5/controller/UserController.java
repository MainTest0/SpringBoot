package com.example.demo5.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@Validated		// GET 방식일 때 반드시 선언해줘야 유효성 검사를 시작한다.
public class UserController {
	
	// GET 방식일 때 파라미터 앞에 어떤 유효성 검사를 할지
	// 당연히 지정해 줘야한다.
	
	// 시작줄에 데이터가 넘어옴
	// http://localhost:8080/user?name=홍&age=1
	// GET 방식일 때 valid 처리
	@GetMapping("/user")
	public User user(@Size(min = 2,max = 10) @RequestParam String name,
			@NotNull @Min(0) @RequestParam Integer age) {
		User user = new User();
		
		user.setName(name);
		user.setAge(age);
		
		return user;
	}
	
	// 문제 GET 방식으로 유효성 검사 직접 만들어보기
	// http://localhost:8080/user2?name=홍&age=1
	// http://localhost:8080/user2?name=홍아리&age=1&email=aasdf&phoneNumber=010-2314-2341
	@GetMapping("/user20")
	public User user20(@Size(min=2, max=5) @RequestParam String name,
			@NotNull @Min(0) @RequestParam Integer age, @NotNull @RequestParam String email,
			@NotNull @Size(max=14) @RequestParam String phoneNumber) {
		
		User user = new User();
		
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		
		return user;
	}
	
	@GetMapping("/user2")
	// http://localhost:8080/user2?name=홍&age=11&email=asdf@naver.com&phoneNumber=010-1234-1234
	// object mapper 통해서 파싱 처리 하고싶다면
	// valid는 POST 방식에서 씀
	// validated는 GET
	public User user2(@Validated User user) {
		
		return user;
	}

}// end of class
