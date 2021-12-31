package member;

import java.util.Scanner;
/*
홍길동,900206-1,010-2242-3810
김자바,071015-4,010-1111-2222
홍자동,890723-1,010-2222-3333
*/
public class MemberExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member[] list = new Member[10];
		int cnt=0;
		while(cnt<10) {
			//자료입력n: 홍길동,900206-1,010-2242-3810
			System.out.print("자료입력 "+(cnt+1)+": ");
			String s = sc.nextLine();
			if(s.equalsIgnoreCase("end")) break;
			list[cnt] = new Member();
			list[cnt].name=s.split(",")[0];
			list[cnt].birth=s.split(",")[1].split("-")[0];
			list[cnt].sex=s.split(",")[1].split("-")[1];
			list[cnt].tel=s.split(",")[2];
			cnt++;
		}
		sc.close();
		
		MemberData mD = new MemberData(list,cnt);
		mD.print();
		
	}

}
