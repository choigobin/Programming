import java.util.Scanner;

/*	이차원 배열
 * 	sc.nextLine();// buffer(임시기억장소) 비우기
 */
public class Exam_02 {
	public static void main(String[] args) {
		int score[][] = new int[5][4];
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		System.out.print((cnt+1)+"번 입력 번호 : ");
		int b = sc.nextInt();
		sc.nextLine();// buffer(임시기억장소) 비우기
		System.out.print((cnt+1)+"번 입력 국어 : ");
		int k = sc.nextInt();
		System.out.print((cnt+1)+"번 입력 영어 : ");
		int e = sc.nextInt();
		sc.close();
		
		System.out.println("번호"+b);
		System.out.println("국어"+k);
		System.out.println("영어"+e);
		/*
		while(cnt<5) {
			System.out.print((cnt+1)+"번 입력 : ");
			score[cnt][0]=cnt+1;
			score[cnt][1]=sc.nextInt();
			score[cnt][2]=sc.nextInt();
			score[cnt][3]=sc.nextInt();
			cnt++;
		}
		sc.close();
		*/
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
