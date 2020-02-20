/*	문자열 분리
 * 	substring(시작, 끝) ==> 끝-1까지 ps) 시작>=substring<끝
 * 	substring(시작) ==> 끝까지 ps)시작>=substring
 */
public class Exam_05 {
	public static void main(String[] args) {
		String str = "Hello World Java";
		// 전체 문자열 길이 계산
		int length = str.length();
		System.out.println(length);
		// Hello 문자만 추출
		String a = str.substring(0,5);
		System.out.println(a);
		// Java만 추출
		System.out.println(str.substring(12));
		
		// 한 글자씩 분리해서 추출
		for(int x=0; x<str.length();x++) {
			char ch = str.charAt(x);
			System.out.println(ch);
		}
		
		
	}

}
