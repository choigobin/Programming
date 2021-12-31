/*	상수 : 변하지않는 값
 * 	변수 : 단 하나의 값을 저장할 수 있는 메모리 공간 
 * 		1)첫자는 숫자X -> 될 수 있는대로 소문자로 시작
 * 		2)대소문자 구분되며 길이제한 없음
 * 		3)특수문자는 $,_ 만 허용
 * 		4)예약어를 사용해서는 안된다.ex) true(X),True(o)
 * 	변수의 타입
 * 		기본형)논리형(boolean),문자형(char),정수(byte,short,int,long),실수(float,double)
 * 			실제 값을 저장한다./문자형(char) = 정수(유니코드)로 저장, 정수형과 다르지 않음(정수,실수와 연산&변환 가능)
 * 		참조형)객체의 주소를 저장한다. 8개의 기본형을 제외한 나머지 타입 ex)String,배열
 */
public class Exam_01 {
	public static void main(String[] args) {
		int a;
		char c;
		float f;
		double d;
		
		//V = e; //대입 연산자  => V = e; e = e; // V = 변수; e = 상수,변수,수식
		a = 100;
		c='A';//1 //문자는 무조건 '1글자 ' (홀따옴표 안에 있어야함) ex) 문자열은 ""로 감싸기
		f=3.14f;// .소수점이 들어가면 무조건 8byte 더블형으로 인식 f 접미사를 붙여야 4byte로 인식
		d=3.14;
		System.out.println(a+c+f+d);
		
	}
}
