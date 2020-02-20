package jslhrd3;
/*	중첩클래스 => 클래스 안에 또 다른 클래스가 있는 것
 * 	1. 중첩(내부)클래스(Inner)
 * 	2. 정적 중첩
 * 	3. 지역 중첩
 * 	4. 익명 중첩
 */
class Outer{
	private int x=10;
	int y=20;
	void disp() {
		System.out.println("x="+x);
		System.out.println("y="+y);
	}
	class Inner{//상속이 아니기 때문에 Outer의 메소드를 사용할 수 없음,Outer의 멤버변수는 접근가능!
		int a=100;
		void disp() {
			x=5;
			System.out.println("x="+x);
			System.out.println("y="+y);
			System.out.println("a="+a);
		}
	}
}
public class Exam_01 {
	public static void main(String[] args) {
		Outer ot = new Outer();
		ot.disp();
		System.out.println("----------");
		Outer.Inner oi = new Outer().new Inner();
		oi.disp();
		System.out.println("----------");
		Outer.Inner oi2 = ot.new Inner();
		oi2.disp();
		System.out.println("----------");
		ot.disp();
	}

}
