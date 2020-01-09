import java.util.Scanner;

/*	이차원 배열
 * 	sc.nextLine();// buffer(임시기억장소) 비우기
 */
public class Exam_03 {
	public static void main(String[] args) {
		int score[][] = new int[5][4];
		Scanner sc = new Scanner(System.in);
		
		for(int x=0; x<score.length;x++) {
			System.out.print((x+1)+"번 입력 : ");
			score[x][0] = x+1;
			score[x][1] = sc.nextInt();
			score[x][2] = sc.nextInt();
			score[x][3] = sc.nextInt();
			sc.nextLine();
		
		}
		sc.close();
		
		//입력자료 출력
		System.out.println("번호\t국어\t영어\t수학");
		for(int x=0; x<score.length; x++) {
			for(int y=0; y<score[x].length; y++) {
				System.out.print(score[x][y]+"\t");
			}
			System.out.println();
		}
		
		
		
	}
}
