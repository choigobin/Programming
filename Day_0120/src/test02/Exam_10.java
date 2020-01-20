package test02;
/*	추상 클래스 - 미완성 설계도
 * 	abstract 키워드 사용
 */
abstract class AA{// 추상클래스 => 객체 생성이 안됨
	int x=100;
	void test() {
		System.out.println("x="+ x);
	}
	abstract int sum(int x, int y);//자손클래스는 반드시 추상메소드를 오버라이딩 해야함, 추상클래스에서만 추상메소드를 정의할 수 있다.
}
class BB extends AA{
	@Override
	int sum(int x, int y) {
		
		return 0;
	}
}
public class Exam_10 {
	public static void main(String[] args) {
		//AA a = new AA(); //객체 생성불가
		AA a = new BB();
		a.sum(1,500);
		
	}

}
