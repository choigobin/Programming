/*	접근제어자(Access Modifier)
 * 	아래로 갈 수록 범위가 넓어짐
 * 	private // 외부 클래스에서 접근 불가능
 * 	default // 기본값, 같은 패키지에서만 접근 가능
 * 	protected // 같은패키지 또는 상속 받은 클래스가 접근 가능
 * 	public // 패키지에 관계없이 접근 가능
 * 	
 * 	클래스파일에 하나의 public class(파일과 이름이 같은 클래스)만 만들 수 있는이유
 * 	가독성을 위하여 하나의 파일에 대표 클래스가 무엇인지 파악하기 쉽게하도록 제한해두었다.
 */
public class AccessModifier {
	private int a = 10;
	int b = 10; // 접근제어자 생략 => 기본 default => 같은 패키지에서 쓸 수 있다.
	private void test() {
		int x =a;
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