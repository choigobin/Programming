import java.util.Scanner;

/*	키보드로 10개의 점수를 입력받아서
 * 	배열에 저장후 총점, 평균을 구하여 출력
 */
public class Exam_03 {
	public static void main(String[] args) {
		// 입력 작업
		Scanner scn = new Scanner(System.in);
		int var[] = new int[10];
		
		for(int i=0; i<10;i++) {
			System.out.print("점수("+(i+1)+") :");
			var[i] = scn.nextInt();
		}
		scn.close();
		// 출력 작업
		int tot = 0;
		for(int i=0; i<10;i++) {
			System.out.print("점수("+(i+1)+")\t");
			tot= tot+var[i];
		}
		System.out.print("총점\t평균\n");
		for(int i=0; i<10;i++) {
			System.out.print(var[i]+"\t");
		}
		System.out.print(tot+"\t"+(tot/10)+"\n");
		
	}
}
