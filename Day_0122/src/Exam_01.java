/*	String 클래스
 * 	장점 : "문자열" 상수를 가상머신 전체에서 공유
 * 		   문자열은 불변
 */
class AA{
	
}
public class Exam_01 {
	public static void main(String[] args) {
		String str1="123";
		String str2="123";//"123"문자열이 이미 있기 때문에 공유한다. => str==str2 : true
		String str3= new String("123");// new를 쓰면 무조건 새로 만든다.
		System.out.println("str1==str2 : "+(str1==str2));//== 연산자는 실제 값이아니라 주소를 비교함
		System.out.println("str1==str3 : "+(str1==str3));// ==는 연산자, equals()는 메소드
		System.out.println("str2==str3 : "+(str2==str3));// 메소드보다 연산자의 속도가 훨씬 빠름 // 속도 : == > equals()
		System.out.println("str1.equals(str3) : "+str1.equals(str3));// equals() 메소드는 실제 값을 비교
		
	}

}
