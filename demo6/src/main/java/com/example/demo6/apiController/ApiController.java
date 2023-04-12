package com.example.demo6.apiController;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.dto.User;

@RestController
@RequestMapping("/api")
@Validated	//하나씩 key=value 검사는 명시 해야한다. 단, GET방식에서 dto 방식은 예외
public class ApiController {
	
	@GetMapping("/test")
	public String test() {
		
		
		
		return "TEST";
	}
	
	// http://localhost:8080/api/user?name=홍아&age=1
	@GetMapping("/user")
	public User get(@RequestParam @Validated String name,
			@RequestParam Integer age) {
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		
		return user;
	}
	
	// 구분 : http body에 데이터 전달 방식
	// 1. json 형식으로 넣어서 서버로 전달 @RequestBody 선언해야함
	// 2. form 태그 활용해서 key-value 구조로 던지는 방식(query String)
	@PostMapping("/user")
	public User post(@RequestBody @Valid User user) {
		
		return user;
	}
	
	// 두번째 연습
	// 던질 때 xww-form-urlincoded MIMETYPE으로 던질거임
	@GetMapping("/user2")
	public User get2(@Validated User reqUser) {	// 여기서 requestParam 안해주는 이유
		
		
		
		return reqUser;
	}
	
}// end of class
