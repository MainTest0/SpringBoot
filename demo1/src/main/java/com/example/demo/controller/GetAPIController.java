package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

//@Controller <-- 화면 응답(HTML(jsp))
@RestController		// Json 방식으로 응답 처리가 된다.
@RequestMapping("/api")
public class GetAPIController {
	
	// 주소 : GET 방식
	// http://localhost:8080/api/hello <-- path variable 방식
	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}
	
	// 쿼리 파라미터 방식으로 데이터를 파싱해서 처리하기
	// http://localhost:8080/api/queryParam1?name=홍아
	@GetMapping("/queryParam1")
	public String queryParam(@RequestParam String name) {
		System.out.println("name : " + name);
		return "name : " + name;
	}
	
	
	// http://localhost:8080/api/queryParam2?name=홍아&age=10
	// http://localhost:8080/api/queryParam2?name=홍아
	// 쿼리 스트링 방식으로 주소설계 서버에서 했다면 요청시에 정확히 맞춰 주어야 한다.
	// 아니면 오류 발생(하지만 선택적 요소로 만들 수도 있다.)
	@GetMapping("/queryParam2")
	public String queryParam2(@RequestParam String name,
			@RequestParam(required = false, defaultValue = "0") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name, age : " + name + age;
	}
	
	// http://localhost:8080/api/queryParam3?name=홍아&age=10
	// http://localhost:8080/api/queryParam3?name=홍아&age=10&group=com.tenco
	@GetMapping("/queryParam3")
	public String queryParam3(@RequestParam Map<String, String> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey()+"=" + entry.getValue());
		});
		
		System.out.println("data : " + data.toString());
		
		return "파싱 map 방식의 이해 : " + sb;
	}
	
	// Map 활용  (직접 만들어 보기)
	// http://localhost:8080/api/queryParam14?name=홍아&age=10
	@GetMapping("/queryParam14")
	public String queryParam14(@RequestParam Map<String, String> data) {
		
		StringBuffer sb = new StringBuffer();
		
		data.entrySet().forEach(entry ->{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			sb.append(entry.getKey()+ "=" + entry.getValue());
		});
		
		return "Map 활용 : " + sb;
	}
	
	// 주소설계 : GET 방식(헤더에만 넣어짐)
	// http://localhost:8080/api/queryParam4?name=홍아&age=10&email=a@naver.com
	@GetMapping("/queryParam4")
	// MessageConverter라는 녀석이 동작해서 자동으로 파싱처리
	// @RequestParam이 Dto 방식으로 동작하려면 동작안해야한다.
	// dto 속성값이 없으면 파싱을 하지않는다.
	// (클래스 안에 있는 멤버변수와 일치하는 값만 파싱)
	public String queryParam4(UserRequest userDto) {
		
		System.out.println("dto 방식 동작 처리");
		System.out.println(userDto.getName());
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		
		return userDto.toString();
	}
	
	// pathVariable 방식의 사용
	// http://localhost:8080/api/path-variable/10
	@GetMapping("/path-variable/{userId}")
	public String pathVariable1(@PathVariable int userId) {
		
		System.out.println("userId : " + userId);
		
		return "userId : " + userId;
	}
	
	// 변수명을 똑같이 사용하지 못할 때 옵션값을 지정할 수 있다.
	// http://localhost:8080/api/path-variable2/홍길동
	@GetMapping("/path-variable2/{name}")
	public String pathVariable2(@PathVariable(name = "name") String mName) {
		
		String name = "내부에서 name 변수명이 있지요";
		System.out.println(name);
		
		return "name : " + mName;
	}
	
	// GET 방식
	// http://localhost:8080/api/users/3/orders/10
	@GetMapping("/users/{userId}/orders/{orderId}")
	public String getOrder(@PathVariable int userId,
			@PathVariable int orderId) {
		
		return "userId : " + userId + " orderId : " + orderId;
	}
	
	// http://localhost:8080/api/name/흥아
	// DTO 매핑은 @pathVariable 선언 없이 사용하자
	// DTO 안에 매핑할 변수와 키 값이 같아야 한다.
	@GetMapping("/name/{name}")
	public UserRequest getUser(UserRequest dto) {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setName(dto.getName());
		
		return userRequest;
	}
	
}// end of class
