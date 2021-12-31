import java.util.Scanner;

/*	키보드로 게임수 입력 받아서 출력
 * 	게임수 : 5
 * 	1: 4 5 6 8 9 10
 * 	2: 23 45 14 11 27 3
 * 	.	.	.
 * 	5: 13 16 7 6 24 41
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임수 : ");
		int cnt = sc.nextInt();
		int[] lotto = new int[6];
		sc.close();
		for(int g=0; g<cnt; g++) {
			for(int x=0; x<lotto.length; x++) {
				lotto[x] = (int)(Math.random()*45)+1;
				//중복체크
				for(int y=0; y<x; y++) {
					if(lotto[x]==lotto[y]) {
						x--;
						break;
					}
				}
			}
			//정렬
			for(int s=0;s<lotto.length-1;s++) {
				for(int s2=s+1;s2<lotto.length;s2++) {
					if(lotto[s]>lotto[s2]) {
						int temp = lotto[s];
						lotto[s] = lotto[s2];
						lotto[s2] = temp;
					}
				}
			}
			//출력
			System.out.print((g+1)+": ");
			for(int i=0; i<lotto.length; i++) {
				System.out.print(lotto[i]+" ");
			}
			System.out.println();
		}
		
	}

}
