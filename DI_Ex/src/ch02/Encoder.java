package ch02;

public class Encoder {
	
	private IEncoder iEncoder;
	
	public Encoder(IEncoder iEncoder) {
		this.iEncoder =iEncoder;
	}
	public void setEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	
	public String encode(String message) {
		return iEncoder.encode(message);
	}
	
	
	// 기
}
