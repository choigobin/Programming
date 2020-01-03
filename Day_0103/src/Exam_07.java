import java.util.Scanner;

/*	키보드로 정수 입력
 * 	1. 입력 범위 (2 ~ 100)
 * 	2. 입력된 수를 2진수로 변환 출력
 * 	3. 입력예시
 * 		정수 입력 : 101
 * 		입력오류 --> 재입력
 * 		정수 입력 : 10
 * 		10진수(10) : 2진수(1010) --> 종료한다
 */
public class Exam_07 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String binary ="";
		int num;
		while(true) {
			System.out.print("정수 입력 : ");
			int var = scn.nextInt();
			num = var;
			if(var>1 && var<101) {
				while(var>0) {
					int remainder = var%2;
					var=var/2;
					binary = remainder+binary; 
				}
				System.out.println("10진수("+num+") : 2진수("+binary+")");
				scn.close();
				break;
			}
			System.out.println("입력오류");
		}
		/*
		 while(true) {
			System.out.print("정수 입력 : ");
			int var = scn.nextInt();
			num = var;
			if(var>1 && var<101) {
				while(var>1) {
					int remainder = var%2;
					var=var/2;
					binary = remainder+binary; 
				}
				binary = var+binary;
				System.out.println("10진수("+num+") : 2진수("+binary+")");
				scn.close();
				break;
			}
			System.out.println("입력오류");
		}
		 */
		
		
	}

}
