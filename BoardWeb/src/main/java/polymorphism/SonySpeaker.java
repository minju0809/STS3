package polymorphism;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성");
	}
	public void soundUp() {
		System.out.println("SonySpeaker---소리 올린다.");
	}
	public void soundDown() {
		System.out.println("SonySpeaker---소리 내린다.");
	}
}
