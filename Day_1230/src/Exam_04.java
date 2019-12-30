import java.util.Scanner;

/*	정수 2개 입력
 * 	두 수의 차이가 10이상이면 
 * 	큰 수에 -5, 작은 수에 +5
 */
public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		scn.close();
		System.out.println("a = " +a);
		System.out.println("b = " +b);
		/*
		if(a>=b+10) {
			a=a-5;b=b+5;
		}
		if(b>=a+10) {
			a=a+5;b=b-5;
		}
		*/
		// 두 수 차이 계산
		int c;
		if(a>=b) {
			c=a-b;
		}else {
			c=b-a;
		}
		if(c>=10) {
			if(a>b) {
				a = a-5;
				b = b+5;
			}else {
				a = a+5;
				b = b-5;
			}
		}
		System.out.println("a' = " +a);
		System.out.println("b' = " +b);
		
	}
}
