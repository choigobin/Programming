/*
변수의 종류 
1. 정적 변수(static) -> 클래스 변수(메모리가 로딩 될때 생성,메소드 영역에 만들어짐)
2. 멤버 변수(인스턴스 변수)
3. 지역 변수(매개 변수)
 */

class BB{
	int a = 10; // 멤버(인스턴스)변수
	static int b = 20; // 클래스(정적)변수
			    // static변수는 모든 객체가 공유한다.
}


public class Exam_04 {
	public static void main(String[] args) {
		
		BB b1 = new BB();
		
		BB b2 = new BB();
		
		System.out.println("b1.a = "+b1.a);
		System.out.println("b1.b = "+b1.b);
		System.out.println("b2.a = "+b2.a);
		System.out.println("b2.b = "+b2.b+"\n");
		
		b1.b++;
		System.out.println("b1.b++;"+"\n");
		
		System.out.println("b1.a = "+b1.a);
		System.out.println("b1.b = "+b1.b);
		System.out.println("b2.a = "+b2.a);
		System.out.println("b2.b = "+b2.b);
		
		
		
	}
}