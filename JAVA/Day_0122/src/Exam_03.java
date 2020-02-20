import java.io.IOException;

/*	1문자 입력
 * 	System.in.read() --> 1문자를 입력 받아서 정수로 리턴 
 */
public class Exam_03 {
	public static void main(String[] args) throws IOException {
		System.out.print("입력 : ");
		byte[] bytes = new byte[100];
		int cnt = System.in.read(bytes)-2;
		System.out.println("입력수 : "+cnt);
		String s = new String(bytes,0,cnt);
		System.out.println("입력자료 : "+s);
		System.out.println("글자수 : "+s.length());
		
	}

}
