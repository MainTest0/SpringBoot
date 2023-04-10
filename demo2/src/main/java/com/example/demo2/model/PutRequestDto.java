package com.example.demo2.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
// 프론트엔드 개발자가 변수이름을 스네이크케이스(car_list)로 주게됬을 때
// 자동으로 변수이름 맞춰줌
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {
	
	private String name;
	private String age;
	
	private List<CarDto> carList;
	
}
