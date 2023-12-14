package polymorphism;

public class LgTV implements TV {
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리..");
	}
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LgTV --- 전원 켠다");
	}

	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다");
	}

	public void volumeUp() {
		System.out.println("LgTV --- 소리 올린다.");
	}

	public void volumeDown() {
		System.out.println("LgTV --- 소리 내린다.");
	}
}
