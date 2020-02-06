package lambda;
/*	람다식 : 메소드를 하나의 식으로 표현
 * 			익명함수
 */
class AA{
	void test() {
		System.out.println("AAA");
	}
	int test2(int a, int b) {
		return a+b;
	}
}
public class Exam_01 {
	public static void main(String[] args) {
		AA a = new AA();
		a.test();
		//()->{System.out.println("AAA");};
		a.test2(1, 1);
		//(int a, int b) ->{return (a+b);}
		
	}
}
