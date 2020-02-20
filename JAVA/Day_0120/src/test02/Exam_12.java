package test02;
/*	인터페이스(interface) - 명세서
 * 	상수, 추상메소드만 있음 => 속성은 없고 기능만 가지고 있다.
 * 	개발 코드 -- 인터페이스 -- 객체 => 인터페이스 = 개발 코드와 객체 사이를 연결해주는 역할
 * 	인터페이스 => 추상클래스처럼 객체 생성불가
 */
interface Car{
	static final int MAX = 100;
	void test(); // 추상클래스와 달리 abstract 필요없음
	int sum(int x, int b);
}
// 인터페이스 구현
class Truck implements Car{
	@Override
	public int sum(int x, int b) {
		
		return 0;
	}@Override
	public void test() {
		
		
	}
}
public class Exam_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
