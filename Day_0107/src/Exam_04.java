import java.util.Scanner;

/*	키보드입력(2~100)
 * 	입력값이 -99 이면 종료
 * 	입력자료 중 소수를 구하여 출력(최대 5개) -> 소수가 5개 되면 프로그램 종료
 * 	입력 : 5
 * 	...
 * 	입력 : -99
 * 	소수 : x x x x x
 */
public class Exam_04 {
	public static void main(String[] args) {
		int prime[] = new int[5];
		int num=0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("입력 : ");
			int x = sc.nextInt();
			if(x==-99) {
				break;
				}else if(x>=2 && x<=100) {
					for(int i=2;i<=x;i++) {
						if(x%i==0) {
							if(x==i) {
								prime[num] = x;
								num++;
							}
							break;
						}
					}
				}else {
					System.out.println("입력 오류");
				}
			
			
		}while(num<5);
		sc.close();
		System.out.print("소수 : ");
		for(int i=0;i<num;i++) {
				System.out.print(prime[i]+" ");
		}
		
		
	}
}