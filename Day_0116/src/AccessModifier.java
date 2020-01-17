/*	접근제어자(Access Modifier)
 * 	아래로 갈 수록 범위가 넓어짐
 * 	private // 외부 클래스에서 접근 불가능
 * 	default // 기본값, 같은 패키지에서만 접근 가능
 * 	protected // 같은패키지 또는 상속 받은 클래스가 접근 가능
 * 	public // 패키지에 관계없이 접근 가능
 *	
 *	클래스 파일에 하나의 public class만 존재할 수 있는 이유 => 가독성 때문에
 *	파일의 대표 클래스가 무엇인지 알아볼 수 있도록 하기위함
 */
public class AccessModifier {
	private int a = 10;
	int b = 10; // 접근제어자 생략 => 기본 default => 같은 패키지에서 쓸 수 있다.
	private void test() {
		int s=a+20;
	}
}

class BB{
	AccessModifier s = new AccessModifier();
	void test() {
		//s.a=20; //private 는 다른 클래스에서 쓸 수 없다.
		s.b=30;
		//s.test(); //메소드도 private로 막을 수 있다.
	}
}