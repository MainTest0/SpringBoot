package ch01;

public class Button {

	private String name; // 버튼이름
	private IButtonListner iButtonListner;

	public Button(String name) {
		this.name = name;
	}

	// setter 만들어서 주입 시킨다.

	public void setIButtonListner(IButtonListner buttonListner) {
		this.iButtonListner = buttonListner;
	}

	public void click(String message) {
		// 옵저버 패턴이란?
		// 메서드 호출됬을 때 코드가 위에서 아래로 실행된다.
		// 옵저버패턴을 다른말로 콜백 메서드라고한다.
		// 호출이되면 돌아간다라는 의미

		// 옵저버 패턴을 만들기위한 조건
		// 1. 인터페이스 만들기
		// 2. 인터페이스를 composition관계(포함관계)로 선언하기
		// 3. 인터페이스를 구현할 클래스를 받을 setter 메서드를 만들어준다.
		if (iButtonListner != null) {
			this.iButtonListner.clickEvent(message);
		}
	}

}
