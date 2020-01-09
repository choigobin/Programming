import java.util.Scanner;

/*	키보드로(번호 이름 국어 영어 수학 전산)
 * 	입력 : 1 홍길동 77 88 99 80
 * 		. . .
 * 	입력 : -99 --> 입력 종료(최대 10명)
 * 
 * 	출력
 * 	번호	이름	국어	영어	수학	전산	총점	평균 
 *   .	 .	 .	 .	 .	 .	 .	(정수)
 *  합계		xx	xx	xx	xx	xx
 * 	평균		x.xx	x.xx	x.xx
 * 	총점평균 이상인 학생 출력
 * 	번호	이름	평균
 *   .	 .	 .
 *  처리조건
 *  1. 과목평균은 정수만(소수점이하 버림)
 *  2. 전체 평균은 소수이하 둘째자리에서 반올림
 */
public class Exam_12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score[][] = new int[11][7];
		String name[] = new String[10];
		
		//입력 작업
		int cnt=0;
		while(cnt<10) {
			System.out.print("입력 : ");
			score[cnt][0] = sc.nextInt();
			if(score[cnt][0]==-99) break;
			name[cnt] = sc.next();
			score[cnt][5] += score[cnt][1] = sc.nextInt();
			score[cnt][5] += score[cnt][2] = sc.nextInt();
			score[cnt][5] += score[cnt][3] = sc.nextInt();
			score[cnt][5] += score[cnt][4] = sc.nextInt();
			sc.nextLine();
			score[cnt][6] = score[cnt][5]/4;
			score[10][1] += score[cnt][1];
			score[10][2] += score[cnt][2];
			score[10][3] += score[cnt][3];
			score[10][4] += score[cnt][4];
			score[10][5] += score[cnt][5];
			cnt++;
		}
		sc.close();
		//입력자료 출력
		System.out.println("번호\t이름\t국어\t영어\t수학\t전산\t총점\t평균");
		for(int x=0; x<cnt; x++) {
			System.out.print(score[x][0]+"\t");
			System.out.print(name[x]+"\t");
			for(int y=1; y<7; y++) {
				System.out.print(score[x][y]+"\t");
			}
			System.out.println();
		}
		System.out.print("합계\t\t");
		for(int x=1; x<6; x++) {
			System.out.print(score[10][x]+"\t");
		}
		System.out.println();
		System.out.print("평균\t\t");
		for(int x=1; x<6; x++) {
			System.out.print((int)((score[10][x]/(double)cnt)*10+0.5)/10.+"\t");
		}
		System.out.println();
		//총점평균 이상인 학생 출력
		double avg = (int)((score[10][5]/(double)cnt)*10+0.5)/10.;
		System.out.println("번호\t이름\t평균");
		for(int x=0; x<cnt; x++) {
			if(score[x][5] > avg) {
				System.out.print(score[x][0]+"\t");
				System.out.print(name[x]+"\t");
				System.out.print(score[x][6]+"\n");
			}
		}
		
	}
}
