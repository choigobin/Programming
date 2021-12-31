package jslhrd4;

import java.io.IOException;

/*	예외 처리
 * 	최상위 클래스 Exception
 */
public class Exam_05 {
	public static void main(String[] ar) {
		
		try {
			int a = System.in.read();
			System.out.println("a = "+a);
		}catch(IOException e) {
			System.out.println("예외가 발생");
			e.printStackTrace();
		}catch(Exception ee) {//하나의 try에 여러개의 catch를 쓸 수 있다. 다음으로 갈수록 범위가 넓어져야함!
			ee.printStackTrace();
		}finally {
			// 예외 발생과 관계없이 수행
		}
		
		
		
	}
}
