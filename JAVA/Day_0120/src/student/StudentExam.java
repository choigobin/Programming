package student;

import java.util.Scanner;

public class StudentExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호,이름,점수[10] : ");
		int bun = sc.nextInt();
		String name = sc.next();
		int[] jum = new int[10];
		int cnt=0;
		while(cnt<10) {
			jum[cnt] = sc.nextInt();
			if(jum[cnt]==-99) break;
			cnt++;
		}
		sc.close();
		StudentHak sh = new StudentHak(bun,name,jum,cnt);
		sh.account();
		sh.scoreMax();
		sh.scoreSelection();
		sh.scoreBubble();
		
	}

}
