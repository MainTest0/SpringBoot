package ch01;

public class MainTest01 {

	public static void main(String[] args) {

		// 옵저버 패턴을 배워보자
		Button button = new Button("button1");
		// 인터페이스 -> 익명 클래스 -> 익명 구현 클래스
		button.setIButtonListner(new IButtonListner() {

			@Override
			public void clickEvent(String event) {
				// 하고싶은 동작, 알고리즘을 구현하면 된다.
				System.out.println("콜백 들어왔어 !!! \n" + event);
			}
		});
		// ----------------------------------콜백 메서드 = 옵저버 패턴 설계완료
		// 메서드 호출
		// 코드가 위에서 아래로 떨어져야되는데
		// 메서드가 호출되는 순간 위로 돌아감
		button.click("야 너 집에가야지 엄마 기다려");
		button.click("이게 정말 콜백이야");
		button.click("맞아 옵저버 패턴이라고도 불려");
	}

}
