package com.example.demo5.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor	// 모든 생성자
@Builder			// 빌더 패턴 만들기
public class User {
	@NotNull(message = "이름")
	private String name;
	@Min(10)
	@Max(100)
	private int age;
	@Email(message = "넌 이메일 형식도 모르니?")
	private String email;
	private String phoneNumber;
	
}// end of class
