import java.io.IOException;

/* 표준입출력(System.out/System.in)
 * print(), println()
 * System.in.read() --> 1문자(키보드 1타자) 입력
 * 자동 import --> ctl+shift+o
 */
public class Exam_01 { //실행클래스
	public static void main(String[] args) throws IOException{
		System.out.print("입력하세요 : ");
		System.in.read();
	}

}
