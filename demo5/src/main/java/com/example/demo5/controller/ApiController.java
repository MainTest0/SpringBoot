package com.example.demo5.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController		// 데이터를 반환
@RequestMapping("/api")
//@Controller			// 페이지를 반환
public class ApiController {

	// method ; post
	// http://localhost:8080/api/user
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user){
		// Spring Boot 요청시 데이터 기본 파싱 전략은 key=value 구조
		// dto <-- Object Mapper가 알아서 동작을 해서 자동 파싱해서  처리해준다.
		// 유효성 검사 : 예전 방식
		if(user.getAge() < 1 || user.getAge() > 100) {
			// 잘못된 입력 값을 확인
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		
		// 서비스 만들어서 (로직) -> DAO로 던져서  DB insert 처리
		// 정방향 갔다가 역방향으로 돌아와서 마지막에 사용자한테 응답처리
		System.out.println(user);
		return ResponseEntity.ok(user);
	}
	
	// 두번째 연습
	// AOP 기반인 Validation 라이브러리 활용하기
	// 기억해야할 것 
	// 1번. Get 방식일 때 사용 방법과 Post 방식일 때 사용 방법이 약간 다르다.
	// 반드시 Valid 선언을 해줘야 한다.
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user){
		
		// 관점 지향 패러다임 추가
		// AOP 기반의 Valid 라이브러리를 활용하면 공통적으로 들어가야하는 부분의 코드를
		// 분리시킬 수 있다.
		
		return ResponseEntity.ok(user);
	}
	
	// 와일드 카드(제네릭에 물음표 사용 가능)
	// 상황에따라 다른 데이터타입을 반환할 때 사용
	@PostMapping("/user3")
	public ResponseEntity<?> user3(@Valid @RequestBody User user,
		BindingResult bindingResult){
		// bindingResult 클래스를 배워 보자.
		// bindingResult가 @Valid에 대한 결과 값을 가지고 있다.
		if(bindingResult.hasErrors()) {	//hasErrors : 리턴타입 true/false
			// 에러 발생
			// 내가 하고싶은거
			// 필드 - 어떤 필드에서 에러 발생했는지 뽑고싶다.
			// 메세지 - 내용을 반환처리 하고싶다.
			
			// 디버깅 모드로 실행
			// 브레이크포인트 설정
			// 설정시점에 데이터 확인 가능
			// Resume눌러서 다음 브레이크 포인트로 이동
			
			StringBuilder sb = new StringBuilder();
			
			bindingResult.getAllErrors().forEach(error -> {
				
				System.out.println(error.getCode());
				System.out.println(error.getDefaultMessage());
				System.out.println(error.getArguments());
				System.out.println(error.getObjectName());
				
				sb.append("field : " + error.getCode());
				sb.append("\n");
				sb.append("message : " + error.getDefaultMessage());
				sb.append("\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		// 정상 처리
		
		return ResponseEntity.ok(user);
	}
	
}// end of class
