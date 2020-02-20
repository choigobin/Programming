package test01;
class Tv{
	String model;
	int inch;
	
	Tv(String model, int inch){
		this.model=model;
		this.inch=inch;
	}
	void printTv() {
		System.out.println("Tv 모델 : "+model);
		System.out.println("Tv 크기 : "+inch);
	}
}
final class DigitalTv extends Tv{//상속을 받아 생성되는 클래스는 조상클래스를 디폴트생성자로 호출하고 자손클래스가 생성된다.
							//조상클래스의 디폴트생성자가 없으면 생성불가!
	DigitalTv(int a ){
		super("삼성",16); // 조상클래스의 디폴트생성자가 없을 경우, 조상클래스의 생성자를 직접 호출
	}
}
/*
class SmartTv extends DigitalTv{ //final 클래스는 상속받을 수 없다.
								//final => 자신의 상속받아 클래스 생성을 할 수없음. 조상클래스 기능을 잠금!
}
*/
public class Exam_04 {

	public static void main(String[] args) {
		

	}

}
