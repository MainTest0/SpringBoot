package ch02;

public class MainTest01 {
	public static void main(String[] args) {
		
//		Base64Encoder base64Encoder = new Base64Encoder();
//		String result = base64Encoder.encode("오늘의 일기 데이트 예정");
//		System.out.println("result : " + result);
		
		UrlEncoder urlEncoder = new UrlEncoder();
		String result = urlEncoder.encode("오늘의 일기 데이트 예정");
		System.out.println("result : " + result);
		
		String url = "www.naver.com/books.id?=100";
		
		// IEnocder 생성자 타입 -> 의존 주입 설계
		// Base64Encoder <-- IEncoder 타입으로 바라볼 수 있음
		// URLEncoder <-- IEncoder 타입으로 바라볼 수 있다.
		
		//하고싶은 인코더 클래스를 주입만 하면 그 구현 클래스에 맞기 기능 처리가능
		Encoder encoder = new Encoder(new UrlEncoder());
		String result1  = encoder.encode(url);
		System.out.println("result1 : " + result1);
		
		encoder.setEncoder(new Base64Encoder());
		System.out.print("전략패턴 : ");
		System.out.println(encoder.encode("반가워"));
		
		Encoder encoder2 = new Encoder(new Base64Encoder());
		String result2 = encoder2.encode(url);
		System.out.println("result2 : " + result2);
		
		Encoder encoder3 = new Encoder(new MyEncoder());
		String result3 = encoder3.encode(url);
		System.out.println("result3 : " + result3);
		
	}

}
