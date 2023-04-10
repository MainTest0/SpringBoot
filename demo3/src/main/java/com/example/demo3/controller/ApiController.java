package com.example.demo3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.User;

@RestController		//리턴타입을 데이터로
@RequestMapping("/api")
public class ApiController {
	
	//80 포트번호는 주소창에서 생략가능합니다.
	//http://localhost:80/api/hello
	//http://localhost/api/hello
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	// MIME TYPE : text/plain으로 응답처리 해주세요
	// http://localhost/api/text
	// 응답 결과 -> 응답 : text/plain
	@GetMapping("/text")
	public String text() {
		return "응답 결과 -> 응답 : text/plain";
	}
	
	// Response를 Json 형식으로 내려주기
	// http://localhost:80/api/json
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		System.out.println(user.toString());
		// 응답 Object type
		return user;
	}
	
	//	/api/put
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		System.out.println(user.toString());
		// HTTP 메세지 코드를 200으로 직접 세팅했음
		// HTTP 메세지 body에 데이터를 받았던 데이터 user object를 그대로 반환한거임
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
//		return ResponseEntity.status(HttpStatus.OK).body(user);		-> status 메세지 코드 200으로 반환
	}
	
	/* 배우는 이유 */
	/* 클라이언트 (모바일) -> 요청(http 통신)
	 * 일반적으로 모바일 클라이언트는 파싱하기 까다로워서
	 * 데이터를 반환 처리한다 (json형식으로)
	 * 매번 새로운 요청마다 다른 형식으로 리턴을 해주면 api 개발자는 우리한테 욕함
	 * 로직을 계속 만들어야되서
	 * 일괄적인 형식을 만들어서 던져주면 api 개발자는 좋아
	 * ResponseEntity로 일괄적인 형식 만들 수 있음
	 */
	
	// MIME TYPE : text/plain
	// 201번으로 떨어짐
	@PutMapping("/put2")
	public ResponseEntity<String> put2(@RequestBody User user){
		
		// 정상적인 값이 들어왔는지 확인, 인증된 사용자인지 확인하는 비즈니스 로직 많이 넣음
		
		// 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		// 201번이면 생성, 수정을 씀(HttpStatus.CREATED)
		return new ResponseEntity<>(user.toString(), headers, HttpStatus.CREATED);
	}
	
	// ResponseEntity 활용해서 응답을 내려 보자.
	@PutMapping("/put3")
	public ResponseEntity<String> put3(@RequestBody User user){
		
		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<>(user.toString(), headers, HttpStatus.OK);
	}
	
}


