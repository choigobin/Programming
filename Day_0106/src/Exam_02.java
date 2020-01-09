import java.util.Scanner;

/*	키보드로 정수(2~1000) 입력
 * 	1) 2 ~ 입력값 까지의 소수를 출력
 * 	2) 한 줄에 5개씩 출력
 * 	3) 마지막에 소수의 갯수 출력
 * 	4) 예시
 * 	입력 : 50
 * 	2 3 5 7 11
 * 	13 ...
 * 	소수 갯수 : xx
 */
public class Exam_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,cnt=0;
		while(true) {
			System.out.print("입력 : ");
			x = sc.nextInt();
			if(x>=2 && x<=1000) {
				for(int i=2;i<=x;i++) {
					for(int y=2;y<=i;y++) {
						if(i%y==0) {
							if(i==y) {
								cnt++;
								System.out.print(i+"\t");
								if(cnt%5==0) {
									System.out.print("\n");
								}
							}else {
								break;
							}
						}
					}
				}
				if(cnt%5!=0) System.out.println();
				System.out.println("소수 갯수 : "+cnt);
				break;
			}else {
				System.out.println("입력 오류");
			}
			
		}
		sc.close();
		
		
	}
}
