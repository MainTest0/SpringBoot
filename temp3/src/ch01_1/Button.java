package ch01_1;

public class Button {
	
	private String name;
	private IButton iButton;
	
	public Button(String name) {
		this.name = name;
	}

	public void setIButton(IButton iButton) {
		this.iButton = iButton;
	}
		
	public void clickEnvent(String message) {
		
		if(iButton!=null) {
			this.iButton.button(message);
		}
		
	}
	
	

}
