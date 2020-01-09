import java.util.Scanner;

/*	세 개의 정수 중 대,중,소 찾기
 * 	1. 가장 큰 수 찾기
 * 	2. 가장 작은 수 찾기
 * 	조건 연산자 (조건식) ? 참: 거짓;
 */
public class Exam_12 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		System.out.print("정수3 :");
		int c = scn.nextInt();
		scn.close();
		
		if(a<b) {
			int imsi = a;
			a=b;
			b=imsi;
		}
		if(a<c ) {
			int imsi = a;
			a=c;
			c=imsi;
		}
		if(b<c) {
			int imsi = b;
			b=c;
			c=imsi;
		}
		System.out.println("max = "+a+" med = "+b+" min = "+c);
		
		
	}
}
