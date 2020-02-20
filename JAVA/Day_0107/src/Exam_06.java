import java.util.Scanner;

public class Exam_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money[] = new int[10];
		int mon[] = {50000,10000,5000,1000,500,100,50,10,5,1};
		int total=0;
		
		while(true) {
			System.out.print("입력 : ");
			int m = sc.nextInt();
			if(m==-99) {
				break;
			}else if(m>99999 && m<1000001) {
				total += m;
				for(int i=0;i<mon.length;i++) {
					money[i] += m/mon[i];
					m %=mon[i];
				}
			}else {
				System.out.println("입력 오류");
			}
		}
		sc.close();
		System.out.println("총 급여 : "+total);
		System.out.println("50,000\t10,000\t5,000\t1,000\t500\t100\t50\t10\t5\t1");
		for(int i=0;i<10;i++) {
			System.out.print(money[i]+"\t");
		}
		
		
		
		
	}
}
