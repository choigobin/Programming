import java.util.Scanner;

/*	키보드입력
 * 	50~90 사이의 자료 10개 입력 합계 출력
 * 	입력 예시
 * 	10,80,60,90,95, ......
 */
public class Exam_08 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int sum = 0; // 합계
		int var; // 입력자료 보관
		int cnt=0; // 데이터 카운트
		
		while(true){
			System.out.print("정수 입력 = ");
			var = scn.nextInt();
			if(var>=50 && var<=90) {
				sum+=var;
				cnt++;
				if(cnt==10) break; // cnt 변동시만 연산 => 속도가 빠름
			}
			//if(cnt==10) break; // cnt 카운트와 관계없이 항상 연산됨 => 속도가 떨어짐
		}
		scn.close();
		System.out.println("합계 = "+sum);
		
	}
}
