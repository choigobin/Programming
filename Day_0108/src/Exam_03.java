import java.util.Scanner;

/* 	키보드 입력 (2 ~ 1024) 입력
 * 	입력 값을 2진수 변환해서 출력
 * 	입력 값이 -99 이면 종료
 * 
 * 	예시)
 * 	입력 : 10
 * 	2진수 : 1010
 * 	입력 : 1
 * 	입력 오류
 * 	입력 : 127
 * 	2진수 : 1111111
 * 	입력 : -99
 * 	프로그램 종료
 */
public class Exam_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[11];
		while(true) {
			System.out.print("10진수 : ");
			int a = sc.nextInt();
			if(a==-99) {
				System.out.println("프로그램 종료");
				break;
				}
			int jinsu = sc.nextInt();
			int cnt = 0;
			if(a>=2 && a<=1024) {
				while(true) {
					if(a>jinsu-1) {
						num[cnt]=a%jinsu;
						cnt++;
						a=a/jinsu;
					}else if(a!=0) {
						num[cnt]=a;
						cnt++;
						break;
					}else {
						break;
					}
				}
				System.out.print(jinsu+"진수 : ");
				for(int i=cnt-1;i>=0;i--) {
					System.out.print(num[i]);
				}
				System.out.println();
			}else {
				System.out.println("입력 오류");
			}
		}
		sc.close();
		
		
		
		
		
	}
}
