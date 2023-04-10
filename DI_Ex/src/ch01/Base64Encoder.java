package ch01;

import java.util.Base64;

public class Base64Encoder implements IEncoder{

	@Override
	public String encode(String message) {
		
		// Base64 형식으로 인코딩 처리
		
		String resultEncode = Base64.getEncoder().encodeToString(message.getBytes()/*변환하고싶은데이터*/);
		
		return resultEncode;
	}

}
