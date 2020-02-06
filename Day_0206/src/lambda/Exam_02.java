package lambda;
/*	함수적 인터페이스 => 메소드가 하나인 인터페이스
 * 	@FunctionalInterface
 */
@FunctionalInterface
interface AAA{
	void method();
}
class BB implements AAA{
	@Override
	public void method() {
		System.out.println("AAAAAA");
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		BB b = new BB();
		b.method();
		AAA aa;
		aa=()->{System.out.println("BBBBBB");};
		aa.method();
		
		
	}
}
