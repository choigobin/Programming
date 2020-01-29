package lotto;

import java.util.Scanner;

public class LottoExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임 수 입력 : ");
		int game =sc.nextInt();; 
		sc.nextLine();
		Lotto[] lotto = new Lotto[game];
		int cnt = 0;
		while(cnt<game) {
			lotto[cnt] = new Lotto();
			cnt++;
		}
		LottoData ld = new LottoData(lotto);
		System.out.print("당첨번호 입력(자동=0) : ");
		int check = sc.nextInt();
		if(check==0) {
			ld.makeAnser();
		}else {
			ld.answer[0] = check;
			for(int i=1; i<7; i++) {
				ld.answer[i] = sc.nextInt();
			}
		}
		sc.close();
		ld.printLotto();
	}

}
