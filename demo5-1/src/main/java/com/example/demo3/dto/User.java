package com.example.demo3.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
	private String name;
	@Email
	private String email;
	private String phoneNumber;
	private int age;
	
	// 빌더패턴
//	복잡한 객체를 생성하는 방법을 정의하는 클래스와 표현하는 
//	방법을 정의하는 클래스를 별도로 분리하여, 서로 다른 
//	표현이라도 이를 생성할 수 있는 동일한 절차를 제공하는 패턴이다.
//User user2 = User.builder()
//.email("티모")
//.age(100)
//.build();
}


