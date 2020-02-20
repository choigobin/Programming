/*	연산자
 * 	산술연산자 -> 관계연산자 -> 상등연산자 ->
 * 	논리연산자 -> 조건연산자 -> 대입연산자(=)
 * 
 * 	1) 산술연산자(()->단항연산자(+,-,++,--,.(dot))
 *		-> *,/,% -> +,-)
 *		/(몫),%(나머지) -> 정수와 정수의 연산은 정수
 */
public class Exam_01 {

	public static void main(String[] ar) {
		int a = 7;
		int b = 5;
		int c = a/b;
		int d = a%b;
		System.out.println("c = "+c);
		System.out.println("d = "+d);

	}

}