package test02;
interface Control{
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	void turnOn();
	void trunOff();
	void setVolume(int volume);
	//디폴트,스태틱 메소드 => JDK 8.0버전에서 추가된 기능 
	//구현한 클래스들에서 메소드를 생성하지 않아도 됨 => 사용하지 않는 메소드라도 인터페이스에서 정의되어있으면 꼭 만들어야 했던 점 보완!
	default void setMute(boolean mute) { //디폴트 메소드=> 구현한 클래스에서 오버라이딩 가능!
		if(mute) {
			System.out.println("무음처리");
		}else {
			System.out.println("무음해제");
		}
	}
	static void changeBattery() { //스태틱 메소드 => 구현한 클래스에서 오버라이딩 불가능! 호출도 인터페이스명을 이용!
		System.out.println("건전지 교체");
	}
}

class Tv implements Control{
	private int volume;
	
	@Override
	public void setVolume(int volume) {
		if(volume>Control.MAX_VOLUME) {
			this.volume = 10;
		}else if(volume<Control.MIN_VOLUME) {
			this.volume = 0;
		}
	}
	@Override
	public void turnOn() {
		System.out.println("TV ON 합니다");
	}
	@Override
	public void trunOff() {
		System.out.println("TV OFF 합니다");
	}
	void print() {
		System.out.println("Tv.volume = " + volume);
		Control.changeBattery();
	}

	
}
public class Exam_14 {
	public static void main(String[] args) {
		Tv t = new Tv();
		t.turnOn();
		t.setVolume(15);
		t.print();
		t.setMute(true);
		Control c = new Tv();
		Control.changeBattery(); // 스태틱메소드는 인터페이스명으로만 메소드 호출!
		c.setMute(false);// 디폴트 메소드는 구현한 클래스명으로 호출가능!
		
	}

}
