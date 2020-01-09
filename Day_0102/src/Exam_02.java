import java.util.Scanner;

/*	키보드로 데이터 입력
 * 	1. 입력자료는 1 ~ 100 사이의 정수
 * 	2. 입력자료 중  7의 배수만 합계와 평균을 구하여 출력
 * 	3. 전체자료(오류포함)이 20개이면 프로그램은 종료.
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
 * 
 * 		입력 자료 20개 중 오류률(%) : xx %
 * 		입력 자료 20개 중 7의 배수율(%) : xx %
 * 		7의 배수 합계 : xxx
 * 		7의 배수 평균 : xx.xx
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x,cnt=0,sum=0,cnt_7=0,err=0;
		do {
			System.out.print("입력 자료  : ");
			x = scn.nextInt();
			cnt++;
			if(x>0 && x<101) {
				if(x%7==0) {
					cnt_7++;
					sum+=x;
				}
			}else {
				System.out.println("error 입력 범위가 아님");
				err++;
			}
		}while(cnt<20);
		scn.close();
		System.out.println("입력 자료 20개 중 오류률(%) : "+(err*5)+"%");
		System.out.println("입력 자료 20개 중 7의 배수율(%) : "+(cnt_7*5)+"%");
		System.out.println("7의 배수 합계 : "+sum);
		System.out.println("7의 배수 평균 : "+(int)((double)sum/cnt_7*100+0.5)/100.);
	}
}
