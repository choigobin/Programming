/*	상수(Lutual) => Data(값){숫자(+,-,*)	=>{정수,실수
 * 						  {문자 => 1문구 ''
 * 						  {문자열
 * 0x7 : 16진수 7
 * 07  : 8진수 7
 * 0b1 : 2진수 1
 * 
 * 	변수 => 임시기억장소 ==> 첫글자가 숫자X {클래스(인터페이스) - 첫글자가 대문자 ex)SoeulKorea
 * 		     ㄴ상수를 기억	      사용자 정의어	 {변수 - 첫글자가 소문자ex)seoulKorea(상수 ex.PI,SEOUL_KOREA)
 * 					  (<=>예약어)	 {메소드 - ()로 끝남
 * 	자료형 => 기억공간의 크기,Type
 * 		{기본자료형	{논리 => boolean
 * 				{숫자 =>{정수 =>byte,short,char(=문자),int,long //short(음수O),char(음수X)
 * 					  {실수 =>float,double
 * 		{참조형
 * 
 */
public class Exam_01 {
	public static void main(String[] args) {
		
		int a;
		char ch;
		float fi;
		double di;
		
		a=65;
		ch='A';
		ch=65;// char형 정수도 저장가능
		fi=3.14f; // 소수점 적으면 자동으로 더블로 인식 접미사 f를 붙여야 플롯으로 인식
		di=3.14;
		
		System.out.println("abc\n456");
		System.out.print("abc\r456");
		
		
		
		
		
	}
}
