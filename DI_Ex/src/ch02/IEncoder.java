package ch02;

public interface IEncoder {
	// 2가지 인코딩 방식 쓸거임
	// URL 인코딩, Base64 인코딩
	// 문자형 데이터 (바이너리 타입을 문자형으로 변경할 때 Base 64 형태)
	String encode(String message);
	
}
