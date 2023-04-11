package com.example.demo3.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// http://localhost:8080/api/test
	@PostMapping("test")
	public ResponseEntity<User> user(@RequestBody User user) {

		if (user.getAge() < 1 || user.getAge() > 100) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		System.out.println(user);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/test2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user){
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/test3")
	public ResponseEntity<?> test3(@Valid @RequestBody User user,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			StringBuffer sb = new StringBuffer();
			
			bindingResult.getAllErrors().forEach(error ->{
				sb.append(error.getCode());
				sb.append(error.getDefaultMessage());
				sb.append(error.getObjectName());
				sb.append(error.getArguments());
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		
		
		return ResponseEntity.ok(user);
	}

}
