package sawon;

import java.util.Scanner;

public class SawonPayExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		Sawon[] sa = new Sawon[10];
		while(cnt<10) {
			sa[cnt] = new Sawon();
			System.out.print("사원정보 : ");
			sa[cnt].id = sc.next();
			if(sa[cnt].id.equals("end")) {break;}
			sa[cnt].rank = sc.nextInt();
			sa[cnt].workTime = sc.nextInt();
			sc.nextLine();
			while(sa[cnt].rank>3) {
				System.out.println("RANK 오류!!");
				System.out.print("사원정보 : ");
				sa[cnt].id = sc.next();
				if(sa[cnt].id.equals("end")) {break;}
				sa[cnt].rank = sc.nextInt();
				sa[cnt].workTime = sc.nextInt();
				sc.nextLine();
			}
			SawonPay.cal(sa[cnt]);
			cnt++;
		}
		sc.close();
		SawonPay.print(sa, cnt);
		
	}
}
