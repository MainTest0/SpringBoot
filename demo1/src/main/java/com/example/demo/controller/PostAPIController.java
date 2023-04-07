package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PostReqDto;

// 요청 응답을 받는 웹 컨퍼넌트
// JSON 형식으로 데이터를 리턴하려면
@RestController
@RequestMapping("/api2")
public class PostAPIController {

	// POST로 보낼 때는 클라이언트에서 어떤 값을 보낼지 이미 알고있다.
	// METHOD : POST
	// 시작줄의 설계주소 : http://localhost:8080/api2/post1
	// 클라이언트에서는 데이터를 JSON 형식으로 보낼 예정
	@PostMapping("/post1")
	public void post1(@RequestBody Map<String, Object> reqData) {
		
		reqData.entrySet().forEach( e -> {
			System.out.println("key : " + e.getKey());
			System.out.println("value : " + e.getValue());
		});
	}
	
	// DTO로 매핑하는 방식 살펴보기
	// http://localhost:8080/api2/post2
	// Dto 방식으로 처리 + JSON 형식으로 응답 처리
	@PostMapping("/post2")
	public PostReqDto post2(@RequestBody PostReqDto reqDto) {
		
		System.out.println(reqDto.toString());
		
		return reqDto;
	}
	
	// GET : 주소 : path
	@GetMapping("/chat/{{message}")
	public String message(@PathVariable String message) {
		
		System.out.println("message : " + message);
		
		return message;
	}
	
	
	
	
	
	
	
	
	
	
	
} // end of class
