import java.util.Scanner;

/*	키보드로 게임수 입력 받아서 출력
 * 	게임수 : 5
 * 	1: 19 20 34 35 40 43
 * 	.	.	.
 * 	5: 1 10 17 34 38 40
 * 	처리조건
 * 	1게임당 가상으로 100게임 후 발생 빈도가 높은
 * 	6개의 숫자를 추출해서 출력
 */
public class Exam_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임수 : ");
		int cnt = sc.nextInt();
		int[] lotto = new int[6];
		sc.close();
		for(int g=0; g<cnt; g++) {
			int box[][] = new int[45][2];
			for(int re=0; re<45; re++) {
				box[re][0] = re+1;
				box[re][1] = 0;
			}
			for(int game=0; game<100; game++) {
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
				//빈도수 계산
				for(int re=0; re<45; re++) {
					for(int s=0;s<lotto.length;s++) {
						if(box[re][0]==lotto[s]) {
							box[re][1]++;
						}
					}
				}
			}
			//빈도수 정렬
			for(int re=0; re<45-1; re++) {
				for(int re2=re+1; re2<45; re2++) {
					if(box[re][1]<box[re2][1]) {
						int[] temp = box[re];
						box[re] = box[re2];
						box[re2] = temp;
					}
				}
			}
			//빈도수가 높은 6개 삽입
			for(int x=0;x<lotto.length;x++) {
				lotto[x] = box[x][0];
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
