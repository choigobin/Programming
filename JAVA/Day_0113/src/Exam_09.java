import java.util.Scanner;

/*
키보드로 사원번호, 이름, 급여를 입력(5명)
입력 : 1101 홍길동 345978
.....
입력 -99
[출력]
사번   이름   급여   50,000    10,000    .......
 */

class Sawon{
	int sabun;
	String name;
	int pay;
	int money[] = new int[10]; // 5만원~1원 까지 화폐매수 저장 공간

	void count() {
		int temp = this.pay;
		int don = 50000;
		boolean sw = true;
		for(int x = 0; x < money.length; x++) {
			money[x] = temp/don;
			temp = temp%don;
			if(sw) {
				don=don/5;
				sw=false;
			}else {
				don=don/2;
				sw=true;
			}
		}//for문끝
	}

	
}



public class Exam_09 {
	public static void main(String[] args) {
		
		Sawon[] sa = new Sawon[5];
		Scanner sc = new Scanner(System.in);
		
		int[] total = new int[10];
		
		Sawon s;
		
		for(int x = 0; x < sa.length; x++) {
			System.out.print("입력 : ");
			s = new Sawon();
			s.sabun = sc.nextInt();
			s.name = sc.next();
			s.pay = sc.nextInt();
			s.count();
			sa[x] = s;
		}
		
		
		System.out.println("=====================================================================");
		for(int x = 0; x < sa.length; x++) {
			System.out.print(sa[x].sabun+"\t"+sa[x].name+"\t"+sa[x].pay+"\t");
			
			for(int y = 0; y < sa[x].money.length; y++) {
				System.out.print(sa[x].money[y]+"\t");
			}
			System.out.println();
		}
		

		
		
	}
}