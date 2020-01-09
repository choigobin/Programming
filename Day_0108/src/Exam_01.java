import java.util.Scanner;

/*	키보드 입력(1 ~ 10) -> 7개 입력
 * 	입력 : 5
 * 	입력 : 0
 * 	입력오류
 * 	입력 : 9
 * 	 . . . -> 7개 입력시 출력
 * 	[ 출력 ]
 * 	입력 자료 : 5 9 x x x x x
 * 	최댓값 : x
 * 	최솟값 : x
 * 	합계(최대, 최소를 뺀 합계) : xx(xx)
 */
public class Exam_01 {
	public static void main(String[] args) {//입력과 출력의 분리시키는 것이 좋다. -> 모듈화
		//입력
		Scanner sc = new Scanner(System.in);
		int num[] = new int [7];
		int cnt=0;
		while(cnt<7) {
			System.out.print("입력 : ");
			int a = sc.nextInt();
			if(a>0 && a<11) {
				num[cnt] = a;
				cnt++;
			}else {
				System.out.println("입력오류");
			}
		
		}
		sc.close();
		//계산
		int max=num[0],min=num[0],sum=num[0];
		for(int i=1; i<num.length; i++) {
			if(max<num[i]) {
				max=num[i];
			}
			if(min>num[i]) {
				min=num[i];
			}
			sum +=num[i];
		}
		//출력
		System.out.print("입력 자료 : ");
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println("\n최댓값 : "+max);
		System.out.println("최솟값 : "+min);
		System.out.println("합계(최대,최소를 뺀 합계) : "+sum+"("+(sum-max-min)+")");
	}
}