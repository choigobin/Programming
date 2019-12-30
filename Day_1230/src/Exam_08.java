import java.util.Scanner;

/*	세 개의 정수 중 대,중,소 찾기
 * 	1. 가장 큰 수 찾기
 * 	2. 가장 작은 수 찾기
 */
public class Exam_08 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		System.out.print("정수3 :");
		int c = scn.nextInt();
		scn.close();
		int max = 0;
		if(a>b) {
			if(a>c) {
				max=a;
			}else {
				max=c;
			}
		}else {
			if(b>c) {
				max=b;
			}else {
				max=c;
			}
		}
		
		System.out.println("max : "+max);
		
	}
}
