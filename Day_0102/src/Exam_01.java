import java.util.Scanner;

/*	키보드로 데이터 입력
 * 	1. 입력자료는 1 ~ 100 사이의 정수
 * 	2. 입력자료 중 3의 배수이면서 7의 배수만 합계와 평균을 구하여 출력
 * 	3. 입력자료가 7개이면 프로그램은 종료.
 * 	4. 입력 예시
 * 		입력자료 : 0
 * 		"error 입력 범위가 아님"
 * 		입력자료 : 8
 * 		입력자료 : 77
 * 		입력자료 : 200
 * 		"error 입력 범위가 아님"
 * 		입력자료 : 88
 * 			.	.	.
 * 			.	.	.
 * 		입력자료 : 88
 * 		합 계 : xxx
 * 		평 균 : xx.xx
 */
public class Exam_01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x,cnt=0,sum=0,za=0;
		while(cnt<7) {
			System.out.print("입력 : ");
			x = scn.nextInt();
			if(x>0 && x<101) {
				cnt++;
				if(x%3==0 && x%7==0) {
					sum+=x;
					za++;
				}
			}else {
				System.out.println("error 입력 범위가 아님");
			}
		}
		scn.close();
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+((double)sum/za));
		
		
	}
}
