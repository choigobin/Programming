/*	메소드(함수) 정의 및 호출
 * 	f(입력) => 계산 => 출력
 * 	메소드 정의
 * 	접근제어자  리턴타입  메소드명(매개변수){
 *  	계	산	작	업
 * 	}
 * 	접근제어자 = 함수 호출 권한 ex)private, public, 안붙여도 됨
 * 	리턴 타입 = 출력 타입 ex)void(출력값 없음)
 * 	JAVA => 메소드 안에 메소드를 정의할 수 없다.	
 */
public class Exam_01 {
	// 리턴타입 x, 매개변수 x
	static void printA() {
		System.out.println("Method Test");
	}
	public static void main(String[] args) {
		System.out.println("Method Call Test");
		printA();
		System.out.println("Method Call Test");
		
	}
}
