import java.util.Scanner;

/*	2자리 이내 정수를 입력
 * 	1 ~ 입력된 정수까지 합계를 계산하여 출력
 */
public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int var;
		while(true) {
			System.out.print("정수입력(1~99):");
			var = scn.nextInt();
			if(var>=1 && var<=99) {
				int sum = 0;
				for(int x=1;x<=var;x++) {
					sum+=x;
				}
				System.out.println("1 ~ "+var+" 합계 = "+sum);
				scn.close();
				break;
			}
		}
		// 1 ~ var 합계계산 출력
		
	}
}

