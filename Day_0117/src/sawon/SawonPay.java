package sawon;

public class SawonPay {
	static void cal(Sawon sa) {
		switch (sa.rank) {
		case 1:
			sa.payHour = 10000;
			break;
		case 2:
			sa.payHour = 5000;
			break;
		case 3:
			sa.payHour = 2000;
			break;
		}
		if(sa.workTime>36) {
			int x = sa.workTime-36;
			if(x>14) {
				x=14;
				//sa.workTime=50;
			}
			sa.payWeek = (int)(sa.payHour*36+x*sa.payHour*1.5);
		}else {
			sa.payWeek = sa.payHour * sa.workTime;
		}	
	}
	static void print(Sawon[] sa,int cnt) {
		int worktime=0, weekpay=0,vip=cnt-1;
		System.out.println("아이디\t등급\t시급\t근무시간\t주간급여");
		for(int i=0; i<cnt; i++) {
			System.out.print(sa[i].id+"\t"+sa[i].rank+"\t"+String.format("%,d",sa[i].payHour)+"\t");
			System.out.println(sa[i].workTime+"\t"+String.format("%,d",sa[i].payWeek));
			worktime += sa[i].workTime;
			weekpay += sa[i].payWeek;
		}
		System.out.print("*합계\t\t\t"+String.format("%,d",worktime)+"\t"+String.format("%,d",weekpay)+"\t");
		System.out.println("평균 = "+String.format("%,.2f", (double)weekpay/cnt));
		System.out.println("*주간급여를 가장 많이 받는 사원");
		for(int i=0; i<cnt; i++) {
				if(sa[i].payWeek>sa[vip].payWeek) {
					vip=i;
				}else if(sa[i].payWeek==sa[vip].payWeek) {
					if(sa[i].workTime>sa[vip].workTime) {
						vip=i;
					}
				}
		}
		System.out.println(sa[vip].id+"\t"+String.format("%,d", sa[vip].payWeek));
	}
	
}