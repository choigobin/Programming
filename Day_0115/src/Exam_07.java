import java.util.Scanner;

public class Exam_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sawon sa[] = new Sawon[10];
		int cnt=0;
		while(cnt<10) {
			System.out.print("입력 : ");
			int sabun = sc.nextInt();
			if(sabun==-99) break;
			String name = sc.next();
			int pay = sc.nextInt();
			sa[cnt]= new Sawon(sabun,name,pay);
			cnt++;
		}
		SawonData saD = new SawonData();
		saD.sourceDataPrint(sa,cnt);
		System.out.print("정렬기준 사원번호(1,2) : ");
		int n = sc.nextInt();
		sc.close();
		saD.sortDataPrint(sa,cnt,n);//n=1(오름차순),n=2(내림차순)
		saD.sourceDataPrint(sa,cnt);
		
	}
}
