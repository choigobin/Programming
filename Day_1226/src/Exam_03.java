import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //new 연산자 => 객체 생성
		//Scanner => 참조형, 위치저장
		int a = 10;
		System.out.print("정수를 입력하시오 : ");
		a=scn.nextInt();//공백=>다음 입력으로 넘어감
		System.out.print("실수를 입력하시오 : ");
		double b = scn.nextDouble();
		System.out.print("문자열을 입력하시오 : ");
		String c = scn.next();//공백 인식안됨
		System.out.print("문자열을 입력하시오 : ");
		String d = scn.nextLine();// 한 줄 통째로 공백도 인식
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		System.out.println("d = "+d);
		System.out.println("scn = "+scn);
		
		
		
		
		
	}
}
