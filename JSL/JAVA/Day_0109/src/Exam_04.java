import java.util.Scanner;

/*	입력
 * 	번호 국어 영어 수학
 * 	
 * 	출력
 * 	번호 국어 영어 수학 총점 평균
 */
public class Exam_04 {
	public static void main(String[] args) {
		int score[][] = new int[5][6];
		Scanner sc = new Scanner(System.in);
		
		for(int x=0; x<score.length;x++) {
			System.out.print((x+1)+"번 입력 : ");
			score[x][0] = x+1;
			score[x][1] = sc.nextInt();
			score[x][2] = sc.nextInt();
			score[x][3] = sc.nextInt();
			score[x][4] = score[x][1]+score[x][2]+score[x][3];
			score[x][5] = score[x][4]/3;
			sc.nextLine();
		
		}
		sc.close();
		
		//입력자료 출력
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		for(int x=0; x<score.length; x++) {
			for(int y=0; y<score[x].length; y++) {
				System.out.print(score[x][y]+"\t");
			}
			System.out.println();
		}
		
		
		
	}
}
