import java.util.Scanner;

/*	키보드 입력(1~100) 최대 10개 입력
 * 	 짝수만 출력
 */
public class Exam_03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		/*
		for(int x=0; x<10; x++) {
			System.out.print("입력 : ");
			int a=scn.nextInt();
			if(a%2==0) {
				System.out.println(a);
			}
		}
		*/
		int val[] = new int[10];
		//입력작업
		for(int x=0; x<10; x++) {
			System.out.print("입력 : ");
			int a=scn.nextInt(); // a를 검사해서 조건에 맞을 경우에 배열에 넣을 때
			val[x] = a; 
			//val[x] = scn.nextInt(); //바로 넣기
		}
		scn.close();
		//출력
		System.out.print("입력자료 : ");
		for (int i=0; i<10; i++) {
			System.out.print(val[i]+"\t");
		}
		System.out.print("\n짝수 : ");
		for (int i=0; i<10; i++) {
			if(val[i]%2==0) {
				System.out.print(val[i]+"\t");
			}
		}
		
	}
}
