import java.io.IOException;

/*	표준 입력
 * 	System.in.read(); -- 1문자 입력 -- 정수로 변환
 * 	예외처리 필수 ex.throws IOException
 * 	ASCII Code => A=65,a=97,0=48,LF(Line feed)=10,CR(Carrage return)=13
 * 	엔터 => \r\n => 1310
 */
public class Exam_02 {
	public static void main(String[] args) throws IOException {
		
		System.out.print("1문자 입력 : ");
		//int ch = System.in.read(); //A -- ASCII Code (A=65,a=97,0=48)
		//형변환
		char ch = (char)System.in.read();
		System.out.println("ch="+ch);
		
		
	}
}
