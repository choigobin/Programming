/* String 클래스 메소드
 * valueOf(); 지정된 값을 문자열로 변환
 */
public class Exam_01 {
	public static void main(String[] args) {
		int a=100;
		String aa = a+""; // 문자열을 더하게 되면 문자로 변환된다.
		// ## 문자열로 변환하기 가장 쉬운 방법
		
		String ab = String.valueOf(a); 
		//valueOf()는 static 메소드이기 때문에 String class에서 직접 호출
		
		String ac = String.valueOf(true);
		
		// 래퍼 클래스(wrapper) - 기본자료형인데 클래스화 되어 있는 것.
		// int->Integer, byte->Byte, char->Character
		// 다른 기본형들(short...) 의 첫 글자를 대문자로 바꾼다면 래퍼클래스가 된다.
		int b1 = Integer.parseInt(ab);
		int b2 = Integer.parseInt("123");
		int b3 = Integer.valueOf(ab); // 1.8버전 이후에 valueOf()가 생겨 쉽게 문자열로 변환 가능
		
		
		int var=100;
		double dou=3.141592;
		//정수 var=100 실수 dou=3.14 이렇게 출력하고 싶다면??
		System.out.println("정수 var= "+var+" 실수 dou= "+dou);
		
		String s1 = String.format("정수 var=%5d 실수 dou=%5.2f ", var,dou);
		System.out.println(s1);
		// %d 는 정수!!	%5d는 정수 5자리 확보	
		// %5.2f  		
		String s2 = String.format("정수 var=%10d 실수 dou=%10.3f ", var,dou);
		System.out.println(s2);
		// 10자리 확보하고 뒤에서부터 출력.
		// 반올림은 하지 않는다.
		
		
		
		
	}

}