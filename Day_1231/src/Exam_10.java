import java.util.Scanner;

/*	키보드입력
 * 	자료 무제한 입력
 * 	입력 예시
 * 	10,80,60,90,95, ......-1
 * 	입력 자료 중 50~90 사이의 자료만 사용
 * 	단, 입력 자료에 음수가 입력되면 종료와 동시에 합계, 평균 출력
 */
public class Exam_10 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int sum = 0; // 합계
		int var = 1; // 입력자료 보관
		int cnt = 0; // 데이터 카운트
		
		while(var>0){ //break문 안쓰고 무한루프 탈출! => 조건식에 break를 준다.
			System.out.print("정수 입력 = ");
			var = scn.nextInt();
			if(var>=50 && var<=90) {
				sum+=var;
				cnt++;
			}
		}
		scn.close();
		System.out.println("합계 = "+sum+"\t평균= "+((double)sum/cnt));
		
	}
}
