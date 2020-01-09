import java.util.Scanner;

/*	키보드 입력(1~99)
 * 	입력 자료가 -99, 또는 입력자료 건수가 20일 때 종료
 * 	입력 : 77
 * 		. . .
 * 	입력 : -99
 * 	입력 자료 : xx xx xx xx xx xx ... xx
 * 	평균        : xx
 * 	평균에 가장 가까운 수 : xx
 */
public class Exam_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[20];
		int sum=0, cnt=0;
		while(cnt<20) {
			System.out.print("입력 : ");
			int x = sc.nextInt();
			if(x==-99) {
				break;
			}else if(x>0 && x<101){
				num[cnt] = x;
				sum+=x;
				cnt++;
			}else {
				System.out.println("입력 오류");
			}
		}
		sc.close();
		double avg = (double)sum/cnt;
		avg=(int)(avg*100+0.5)/100.;
		int mvp = 100;
		System.out.print("\n입력 자료 : ");
		for(int i=0;i<cnt;i++) {
			System.out.print(num[i]+" ");
			if(mvp<avg) {
				if(num[i]<avg) {
					mvp = ((avg-mvp)<(avg-num[i])) ? mvp : num[i];
				}else {
					mvp = ((avg-mvp)<(num[i]-avg)) ? mvp : num[i];
				}
			}else {
				if(num[i]<avg) {
					mvp = ((mvp-avg)<(avg-num[i])) ? mvp : num[i];
				}else {
					mvp = ((mvp-avg)<(num[i]-avg)) ? mvp : num[i];
				}
			}
		}
		System.out.println("\n평균        : "+avg);
		System.out.println("평균에 가장 가까운 수 : "+mvp);
		
		
		
	}
}