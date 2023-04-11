package ch01_1;

public class CallBackMethod {

	public static void main(String[] args) {

		Button button = new Button("button1");
		IButton iButton;
		
		button.setIButton(new IButton() {
			
			@Override
			public void button(String message) {

				System.out.println("콜백\n"+message);
				
			}
		});
		button.clickEnvent("1");
		button.clickEnvent("2");
		button.clickEnvent("3");
	}

}
