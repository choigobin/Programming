/* #####!!!! 면접 질문!!!
 * p477
 * 
 * String, StringBuffer, StringBuilder 클래스의 차이점!!!!!!!!!!!!
 * String 클래스는 정적인 문자열 - 만들게 되면 변경이 안된다.
 * String는 가상 메모리에서 만들어지만
 * StringBuffer, StringBuilder 는 버퍼를 활용하여 수정이 가능하게 된다.
 *  | 둘 다 동적인 문자열 처리가 가능하다!!
 * 
 * #### StringBuffer, StringBuilder의 차이점
 *  | 멀티 쓰레드 지원(동기화 지원) 여부  - StringBuffer만 지원된다. 
 * 
 * 
 * 
 */
public class Exam_02 {
	public static void main(String[] args) {
		String str1="AAAAA";
		String str2= new String("AAAAA");
		// new를 이용해서 만들었기 때문에 str1과 str2는 서로 다르다.
		
		StringBuffer sb1=new StringBuffer();
		// 반드시 new활용해야 한다. 보편적으로 기본크기는 16자 정도. 버퍼크기 지정 가능. 
		StringBuffer sb2=new StringBuffer(20); // 20자를 초과하면 자동으로 늘어난다.
		System.out.println("sb1 = "+sb1.capacity()); // 공간 크기
		System.out.println("sb1 = "+sb1.length()); // 글자 수
		System.out.println("sb2 = "+sb2.capacity());
		
		sb1.append("BBBBB"); // append 글자가 뒤에 붙이는 메소드
		sb1.append("CCCCC");
		sb1.append("DDDDDDDDDDDDDDDDDDDDDdDDS");
		System.out.println("sb1 = "+sb1.capacity()); // 공간 크기
		System.out.println("sb1 = "+sb1.length()); // 글자 수
	}
	

}