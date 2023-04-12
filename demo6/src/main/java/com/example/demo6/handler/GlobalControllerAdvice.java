package com.example.demo6.handler;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo6.dto.CustomError;

@RestControllerAdvice // IoC의 대상이 된다. (싱글톤 패턴으로 구체가 만들어진다.)
//@ControllerAdvice		// 페이지 리턴 오류시 작동
public class GlobalControllerAdvice {

	// 모든 예외를 여기서 처리하고싶다면
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {

		System.out.println("==========================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("==========================");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	// 특정 예외를 잡아서 다르게 응답 처리하고싶다면 !!!
	// 위에 최상위 클래스 exception이 있지만 여기서 예외가 잡히는게 오버라이드와 같다.
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		// String Builder 사용했었음
		// 데이터 가공해서 적절하게 응답 만들어
		
		List<CustomError> errorList = new ArrayList<>();
		e.getAllErrors().forEach(error -> {
			String field = error.getCode();
			String message = error.getDefaultMessage();
			CustomError customError = new CustomError();
			customError.setField(field);
			customError.setMessage(message);
			errorList.add(customError);
		});

		// 디버깅하기
		// 어떤 필드가 잘못됬는지
		// 메시지 확인하기
		// String 값으로 재 정의해서 응답 처리해주세요

		System.out.println("잘못된 값을 나에게 전달했어");

//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {

		System.out.println("문제 특정 예외 잡아보기");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(value = BindException.class)
	public ResponseEntity<?> bindException(BindException e) {

		System.out.println("GET 방식으로 값을 던질 때 잘못 보냈네!!");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}// end of class
