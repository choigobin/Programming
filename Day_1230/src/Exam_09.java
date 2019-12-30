import java.util.Scanner;

/*	세 개의 정수 중 대,중,소 찾기
 * 	1. 가장 큰 수 찾기
 * 	2. 가장 작은 수 찾기
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		System.out.print("정수3 :");
		int c = scn.nextInt();
		scn.close();
		int max = a; // 가장 큰 값 저장
			if(max<b) {
				max=b;
			}
			if(max<c) {
				max=c;
			}
		
		System.out.println("max : "+max);
		
	}
}
