import java.util.Scanner;

/*	세 개의 정수 중 대,중,소 찾기
 * 	1. 가장 큰 수 찾기
 * 	2. 가장 작은 수 찾기
 * 	조건 연산자 (조건식) ? 참: 거짓;
 */
public class Exam_11 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		System.out.print("정수3 :");
		int c = scn.nextInt();
		scn.close();
		
		int max=0, med=0, min=0;
		if(a>b) {
			if(a>c) {
				max=a;
				if(b>c) {
					med=b;
					min=c;
				}else {
					max=c;
					med=a;
					min=b;
				}
			}
		}else {
			if(b>c) {
				max=b;
				if(a>c) {
					med=a;
					min=c;
				}else {
					med=c;
					min=a;
				}
			}else {
				max=c;
				med=b;
				min=a;
			}
		}
		
		System.out.println("max : "+max);
		System.out.println("med : "+med);
		System.out.println("min : "+min);
	}
}
