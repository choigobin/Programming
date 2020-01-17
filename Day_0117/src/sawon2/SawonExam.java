package sawon2;

import java.util.Scanner;

public class SawonExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sawon[] sa = new Sawon[10];
		int cnt=0;
		while(cnt<10) {
			sa[cnt] = new Sawon();
			System.out.print("사원정보 : ");
			sa[cnt].setPart(sc.next());
			if(sa[cnt].getPart().equals("end") || sa[cnt].getPart().equals("END") ) {
				break;
			}
			sa[cnt].setNo(sc.nextInt());
			sa[cnt].setName(sc.next());
			sa[cnt].setPay(sc.nextInt());
			sc.nextLine();
			cnt++;
		}
		sc.close();
		SawonData.print(sa, cnt);
	}

}