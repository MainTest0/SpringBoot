package com.example.demo2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 데이터로 리턴하고싶다.
@RestController
@RequestMapping("/api2")
public class DeleteAPIController {
	
	// METHOD : delete
	// 주소 : http://localhost:8080/api2/delete/100
	// 주소 : http://localhost:8080/api2/delete/{userId}?account=우리은행
	// 주소 : http://localhost:8080/api2/delete/100?account=우리은행
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId,
		@RequestParam String account) {
		System.out.println("userId : " + userId);
		System.out.println("account : " + account);
	}
	
	// 문제 delete 주소 설계 및 응답 처리
	// path, query, path + query 둘다 사용 해보기
	// http://localhost:8080/api2/delete1/5?pass=552번
	@DeleteMapping("/delete1/{user}")
	public void delete1(@PathVariable String user,
			@RequestParam String pass) {
		System.out.println("user : " + user);
		System.out.println("pass : " + pass);
	}
	
	
}





















