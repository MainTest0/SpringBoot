package com.example.demo2.model;

import lombok.Data;
import lombok.ToString;

@Data		// 게터 세터, toString 한번에 만들어줌
@ToString
public class PostRequestDto {
	
	private String name;
	private String age;

}
