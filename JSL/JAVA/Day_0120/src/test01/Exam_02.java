package test01;
class CC{
	int x=10;
	void test() {
		System.out.println("x="+x);
	}
}
class DD extends CC{
	int y=100;
	void test() {// 오버라이딩 = 메소드 재정의
		//System.out.println("x="+x);
		super.test();
		System.out.println("y="+y);
	}
}
class EE extends DD{
	void test() {
		super.test();// 상속받은 DD의 test()를 불러옴. super => 상속받은 클래스
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		CC c1 = new CC();
		c1.test();
		System.out.println("------------------------------------");
		DD d1 = new DD();
		d1.test();
		
		
	}
}
