package jslhrd3;
/*	정적 중첩
 * 
 */
class Outer2{
	static int stx=10;
	int x=100;
	int y=200;
	void upstx() {
		stx+=1;
	}
	static class Inner2{//내부 클래스를 static으로 만듦 => 클래스변수(static 변수)만 접근가능
		int a=100;
		static int b=30;
		void disp_in() {
			System.out.println("stx="+stx);
			//System.out.println("x="+x); //클래스 변수만 접근 가능
			//System.out.println("y="+y); //인스턴스 변수는 접근 불가
			System.out.println("a="+a);
		}
		void downstx() {
			stx-=1;
		}
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		Outer2 ot = new Outer2();
		//Outer2.Inner2 oi = ot.new Inner2(); // 중첩클래스와 같은 방식으로 생성 불가
		Outer2.Inner2 oi = new Outer2.Inner2();
		System.out.println("x="+Outer2.stx);
		oi.downstx();
		System.out.println("Inner2의 static 변수 = "+Outer2.Inner2.b);
		System.out.println("x="+Outer2.stx);
		ot.upstx();
		System.out.println("x="+Outer2.stx);
		
	}

}
