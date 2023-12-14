package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV {
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	private int price;
	
//	public void destroyMethod() {
//		System.out.println("객체 삭제 전에 처리할 로직 처리..");
//	}
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	

	// Setter 인젝션
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("LgTV --- 전원 켠다");
	}

	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다");
	}

	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("LgTV --- 소리 올린다.");
	}

	public void volumeDown() {
		speaker.volumeDown();
		System.out.println("LgTV --- 소리 내린다.");
	}
}
