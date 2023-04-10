package com.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {
	// http://localhost:8080/api12/helloo
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String getHelo() {
		return "say hello";
	}
	
}//end of class
