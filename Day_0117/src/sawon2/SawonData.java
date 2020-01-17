package sawon2;

public class SawonData {
	static void print(Sawon[] sa,int cnt) {
		String part = sa[0].getPart(), name = sa[0].getName();
		int no = sa[0].getNo(), pay = sa[0].getPay(), partPay=sa[0].getPay(), totPay=sa[0].getPay();
		System.out.println("**급여관리 프로그램**");
		System.out.println("부서명\t사번\t이름\t급여");
		System.out.println("---------------------------");
		System.out.print(part+"\t");
		System.out.println(no+"\t"+name+"\t"+pay);
		for(int i=1; i<cnt; i++) {
			part = sa[i].getPart();
			name = sa[i].getName();
			no = sa[i].getNo();
			pay = sa[i].getPay();
			if(sa[i-1].getPart().equals(sa[i].getPart())) {
				System.out.print("\t");
				partPay += sa[i].getPay();
				totPay += sa[i].getPay();
			}else if(i==cnt-1){
				System.out.println("합계\t\t\t"+partPay);
				partPay=0;
				partPay+=sa[i].getPay();
				totPay += sa[i].getPay();
				System.out.print(part+"\t");
			}else {
				System.out.println("합계\t\t\t"+partPay);
				partPay=0;
				partPay+=sa[i].getPay();
				totPay += sa[i].getPay();
				System.out.print(part+"\t");
			}
			System.out.println(no+"\t"+name+"\t"+pay);
		}
		System.out.println("합계\t\t\t"+partPay);
		System.out.println("총합계\t\t\t"+totPay);
	}
}