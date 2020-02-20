package test01;
/*	상속은 하나만 받을 수 있다.(=다중상속 불가)
 * 	A가 B를 상속받고 C가 B를 상속받을 수 있음.
 * 	C가 한번에 A,B를 상속 받을 수는 없음. A를 상속받은 B를 상속받아야함.
 * 	또는 인터페이스를 활용
 * 	클래스[상속],인터페이스[구현]
 */
class AA{
	int a=10;
	int b=20;
	private int c=30;
	void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
}
class BB extends AA{
	int d = 100;
	void test() {
		System.out.println("a=" +(a+100));
		System.out.println("b=" +(b+100));
		//System.out.println("c=" +c+100);
	}
}
public class Exam_01 {

	public static void main(String[] args) {
		AA a1 = new AA();
		BB b1 = new BB();
		a1.print();
		b1.print();
		b1.test();
	}

}
