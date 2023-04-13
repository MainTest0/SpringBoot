package com.example.testBlog.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping({ "/", "index" })
	public String index() {

		return "index";
	}

	@GetMapping({"post"})
	public String post() {

		return "post";
	}
	
	@GetMapping({"contact"})
	public String contact() {

		return "contact";
	}
	
	@GetMapping({"about"})
	public String about() {

		return "about";
	}

}
