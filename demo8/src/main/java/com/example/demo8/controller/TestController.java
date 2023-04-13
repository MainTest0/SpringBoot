package com.example.demo8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/testHello")
	public String testHello() {
		
		System.out.println("들어옴");
		
		return "test";
	}
	
}
