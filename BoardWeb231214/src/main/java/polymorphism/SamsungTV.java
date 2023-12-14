package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}
	
	public SamsungTV() {
		System.out.println("===> SansungTV(1) 객체 생성");
	}
	
	// 생성자 오버로딩
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SansungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SansungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("SansungTV --- 전원 켠다. (가격: " + price + ")");
	}

	public void powerOff() {
		System.out.println("SansungTV --- 전원 끈다");
	}

	public void volumeUp() {
		// (applicationContext) bean에 sony를 추가하고, 
		// SonySpeaker를 매개변수로 받아서 생성자를 만들면 따로 객체 생성을 하지 않아오 됨
//		speaker = new SonySpeaker(); 
		speaker.volumeUp();
		System.out.println("SansungTV --- 소리 올린다.");
	}

	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker.volumeDown();
		System.out.println("SansungTV --- 소리 내린다.");
	}
}
