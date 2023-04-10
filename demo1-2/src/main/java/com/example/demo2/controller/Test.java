package com.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
	public String test() {
		
		return "say";
	}
	// http://localhost:8080/api/name?name=붕붕
	@GetMapping("/name")
	public String Test1(@RequestParam String name) {
		System.out.println("name : " + name);
		return "name : " + name;
	}
	
	// http://localhost:8080/api/name1?name=방방&age=10
	@GetMapping("/name1")
	public String Test2(@RequestParam String name,
			@RequestParam(required = false, defaultValue = "0") int age) {
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return name+"\n"+age;
	}

}
