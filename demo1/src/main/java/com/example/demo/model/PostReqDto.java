package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor		// 기본생성자 만들기
@AllArgsConstructor		// 모든 생성자 만들기
public class PostReqDto {
	
	private String name;
	private String email;
	private int age;
	private int hobby;
	@JsonProperty("phone_number")
	private int phoneNumber;

}
