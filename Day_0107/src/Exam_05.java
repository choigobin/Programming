import java.util.Scanner;

/*	키보드 입력(100,000 ~ 1,000,000)
 * 	입력자료가 -99 종료
 * 	입력 : 234567
 * 	입력 : 345434
 * 		. . .
 * 	입력 : -99
 * 	총급여 : xxxxxxx
 * 	50,000	10,000	5,000	1,000	500	100	50	10	5	1
 * 	xx		xx		xx		xxx		xx	xx	xx	xx	xx	xx
 */
public class Exam_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money[] = new int[10];
		int total=0;
		
		while(true) {
			System.out.print("입력 : ");
			int m = sc.nextInt();
			if(m==-99) {
				break;
			}else if(m>99999 && m<1000001) {
				total += m;
				boolean flag = true;
				int mon=50000;
				for(int x=0; x<10; x++) {
					money[x] += m/mon;
					m = m%mon;
					if(flag) {
						mon /=5;
						flag=false;
					}else {
						mon /=2;
						flag=true;
					}
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
