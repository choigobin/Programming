import java.util.Scanner;

/*	문자열 처리("") 및 자료형 입력
 * 	문자열 처리 : String 클래스(대문자로 시작 =>클래스 //기본자료형 아님!)
 * 	자료형 입력 : Scanner 클래스(jdk 1.7 이상)
 */
public class Exam_07 {
	public static void main(String[] args) {
		//char ch='A';
		//String str = "AAAAA";
		Scanner scn = new Scanner(System.in);
		String name = scn.next();
		System.out.println("이름 : " + name);
		scn.close();
	}

}

