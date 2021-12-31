/* [자료형 - DateType(기억장소의 크기와 연관)]
 * 
 * {기본 자료형} - 문자 : char
 * 			  - 정수 : byte, int, long
 *			  - 실수 : double, float
 * 			  - 논리 : boolean
 * 
 * 자바에는 문자열 자료형은 없음 원래
 * 
 *{참조형(주소/위치)} - 배열
 *		 		  - 클래스, 인터페이스
 * 
 * -> 면접에서 물어볼 수 있음!
 */
public class Exam_02 {
	public static void main(String[] args) {
		char ch; //2byte 한글 1글자에 2byte(utf-16) 3byte(utf-8)
		int jung; //4byte
		double dou; //8bytec
		boolean bool; //1byte
		
		ch = 'S'; // = -> 대입연산자 -1문자대입
		jung = 123791; //정수대입
		dou = 3.141592; //실수대입
		bool = true; //true(참)대입
		
		System.out.println("char ch = " + ch);
		System.out.println("int jung = " + jung);
		System.out.println("double dou = " + dou);
		System.out.println("boolean bool = " + bool);
	}
}
