import java.util.Scanner;

/*	세 개의 정수 중 중간 값만 찾기
 * 	최대,최소 구하면 안됨
 */
public class Exam_13 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		System.out.print("정수3 :");
		int c = scn.nextInt();
		scn.close();
		
		int med = 0;
		if(a>b) {
			if(a<c) {
				med = a;
			}else {//a>c
				if(b>c) {
					med = b;
				}else {
					med = c;
				}
			}
		}else {//b>a
			if(b<c) {
				med = b;
			}else {//b>c
				if(a>c) {
					med = a;
				}else {
					med = c;
				}
			}
		}
		
		//출력
		System.out.print("정수 1 : " + a + "\t");
		System.out.print("정수 2 : " + b + "\t");
		System.out.print("정수 3 : " + c + "\t");
		System.out.println("med = " + med);
		
		
	}
}
