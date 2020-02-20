import java.util.Scanner;

/*	키보드 입력
 * 	1. 정수 10개를 입력 합을 출력하시오
 * 	
 * 	2. 정수 10개를 입력 합을 출력(단, 입력 값이 음수는 배제한다)
 */
public class Exam_05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		/*
		int sum=0;
		for(int x=1;x<=10;x++) {
			System.out.print("정수 : ");
			int var = scn.nextInt();
			sum+=var;
		}
		scn.close();
		System.out.println("합계 = "+sum);
		*/
		//while()
		int cnt=0; // 갯수
		int total=0; // 합계
		while(cnt<10) {
			System.out.print("정수 : ");
			int var = scn.nextInt();
			if(var>=0) {
				cnt++;
				total+=var;
			}
		}
		scn.close();
		System.out.println("합계 = "+total);
	}
}
