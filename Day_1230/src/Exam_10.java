import java.util.Scanner;

/*	세 개의 정수 중 대,중,소 찾기
 * 	1. 가장 큰 수 찾기
 * 	2. 가장 작은 수 찾기
 * 	조건 연산자 (조건식) ? 참: 거짓;
 */
public class Exam_10 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		System.out.print("정수3 :");
		int c = scn.nextInt();
		scn.close();
		
		int max = (a>b) ? a : b;
		max= (max>c) ? max : c;
		
		System.out.println("max : "+max);
		
	}
}
