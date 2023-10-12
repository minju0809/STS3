package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체(1) 생성");
	}
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	public void powerOn() {
		System.out.println("SamsungTV---전원켠다. (가격 : " + price + ")");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원끈다.");
	}
	public void volumeUp() {
		speaker.soundUp();
	}
	public void volumeDown() {
		speaker.soundDown();
	}
}
