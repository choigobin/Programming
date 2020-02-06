package thread;

import java.awt.Toolkit;

/*	멀티 스레드 => 스레드를 여러개 동시에 => 엄밀히 말하면 동시X => 시분할
 * 	스레드 -> 흐름, 실행코드
 * 	Thread 클래스를 상속받는 경우
 * 	
 * 	Runnable 인터페이스 구현하는 경우
 */
public class Exam_01 {
	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit();
		//싱글스레드
		for(int i=0; i<10; i++) {
			tool.beep();//소리
			try {
				Thread.sleep(500);
			}catch (Exception e) {}
		}
		for(int i=0; i<10; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {}
		}
		
		
		
	}
}
