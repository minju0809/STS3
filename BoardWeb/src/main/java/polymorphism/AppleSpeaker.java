package polymorphism;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker 객체 생성");
	}
	public void soundUp() {
		System.out.println("AppleSpeaker---소리 올린다.");
	}
	public void soundDown() {
		System.out.println("AppleSpeaker---소리 내린다.");
	}
}
