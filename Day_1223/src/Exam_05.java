import java.util.Scanner;

/*	키보드로 임의의 정수 data 10개 입력
 * 	단, data는 50이상 100이하만 입력
 * 	1,60,50,70,-99,69,60
 */
public class Exam_05 {
	public static void main(String[] args) {
		//입력
		Scanner scn = new Scanner(System.in);
		int[] score = new int[10];
		int cnt=0; // data 갯수 카운트
		while(true) {// 무한 루프
			System.out.print("정수 입력 : ");
			int jungsu = scn.nextInt();
			if(jungsu>=50 && jungsu<=100) {
				score[cnt] = jungsu;
				cnt++;
				if(cnt==10) {
					break;
				}
			}
		}
		//출력
		for(int i=0;i<score.length;i++) {
			System.out.println((i+1)+"번째 = "+score[i]);
		}
		
	}
}
