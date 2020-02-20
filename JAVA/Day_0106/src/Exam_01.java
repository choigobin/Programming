import java.util.Scanner;

/*	소수판별
 * 	키보드 입력 x -> ex)x=5 -> 5는 소수인가?
 * 	--------------------------------
 * 	키보드 입력
 * 	1) -99가 입력 될 시 프로그램 종료
 * 	2) 입력 범위는 2 ~ 100
 * 	2) 입력 자료중 소수의 갯수와 합을 구하여 출력
 * 
 * 	입력 : -6
 * 	입력 오류  -> 입력자료가 아님
 * 	입력 : 3
 * 		...
 * 	입력 : -99 -> 입력자료가 아님
 * 	입력 자료 수 : xx
 * 	소수 갯수 : xx
 * 	소수 합계 : xx
 */
public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,cnt=0,sum=0,prime=0,y;
		do {
			System.out.print("입력 : ");
			x= sc.nextInt();
			if(x>=2 && x<=100) {
				cnt++;
				y=1;
				for(int i=2;i<x;i++) {
					if(x%i==0) {
						y=0;
						break;
					}
				}
				if(y==1) {
					sum+=x;
					prime++;
				}
			}else if(x!=-99){
				System.out.println("입력 오류");
			}	
		}while(x!=-99);
		sc.close();
		System.out.println("입력 자료수 : "+cnt);
		System.out.println("소수 갯수 : "+prime);
		System.out.println("소수 합계 : "+sum);
		
		
		
	}
}
