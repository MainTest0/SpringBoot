package ch02;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoder implements IEncoder{
	
	// 객체 생성 + 메서드 호출 -> 의존 주입 받는 형태로 변경할거임
	

	@Override
	public String encode(String message) {
		
		try {
			return URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
