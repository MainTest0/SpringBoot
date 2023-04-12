package com.example.demo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
	
	@GetMapping({"/", "blog"})
	public String blog() {
		
		return "blog";
	}

}
