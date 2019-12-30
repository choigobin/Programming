import java.util.Scanner;

/*	키보드로 정수 2개 입력 크기 비교하기
 * 	
 */
public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("정수1 :");
		int a = scn.nextInt();
		System.out.print("정수2 :");
		int b = scn.nextInt();
		scn.close();
		if(a>b) System.out.println("a>b"); //문장이 1개일 때
		if(a<b)
			System.out.println("a<b"); //문장이 1개일 때
		if(a==b) {
			System.out.println("a==b");
		}
		
		
		
	}
}
