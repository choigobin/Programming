import java.util.Scanner;

/*	키보드로 10개의 정수 data 입력
 * 	합계를 출력
 */
public class Exam_07 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int sum = 0; //누적형 초기화 필요
		int x; // 대입형 초기화 무관
		for(int i=0;i<10;i++) {
			System.out.print("정수 입력 = ");
			//int x = scn.nextInt();// 계속 새로 만들어짐 => 메모리 계속 잡아먹음 => 
			//하지만 자바는 gc(Garbage Collection)으로 쓰지않는 메모리 자동 삭제 
			x = scn.nextInt(); //메모리 1번만 씀
			sum+=x;
		}
		scn.close();
		System.out.println("합계 = "+sum);
		
		
	}
}
