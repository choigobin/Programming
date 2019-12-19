import java.util.Scanner;

/*	정수 2개 입력 크기 비교하기
 *	ex) 79, 88 입력시
 *	 => 79<88
 *		
 *		70, 60 입력시
 *	 => 70>60
 */

public class Exam_05 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("정수a를 입력하시오 : ");
		int a = s.nextInt();
		System.out.print("정수b를 입력하시오 : ");
		int b = s.nextInt();
		
		if(a>b) {
			System.out.println(a+">"+b);
		}else if(a==b){
			System.out.println(a+"="+b);
		}else {
			System.out.println(a+"<"+b);
		}
		
	}

}
