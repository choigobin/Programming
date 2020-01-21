package jslhrd3;
/*	익명 중첩
 * 	- 기존 클래스의 특정 메소드를 오버로딩하여 사용하는 방식
 */
class Inner4{
	void aaa() {
		System.out.println("aaaaaa");
	}
	void bbb() {
		System.out.println("bbbbb");
	}
}
public class Exam_04 {
	public static void main(String[] args) {
		Inner4 in4 = new Inner4();
		in4.aaa();
		in4.bbb();
		System.out.println("-----입력 중첩-----");
		
		Inner4 in = new Inner4() {// 익명 중첩 => 오버라이딩이 목적 => 새로운 메소드 생성 불가
			void aaa() {
				System.out.println("DDDD");
			}
			
		};
		in.aaa();
		in.bbb();
		
		
	}

}
