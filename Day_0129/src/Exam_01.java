import java.util.Scanner;

/*	번호, 이름, 점수 n개를 입력 받아서 출력하는 프로그램을 완성하시오.
 * 	1) 입력항목 - 최대 10개 또는 번호가 -99이면 출력 후 종료
 * 		- 번호, 이름, 점수 5개
 * 	2) 처리조건
 * 		- 점수 출력시 오름차순으로 출력//개인별 점수를 오름차순으로 왼쪽에서 오른쪽으로
 * 	3) 출력
 * 		번호	이름	점수
 * 		1	AA	77	80	87	90	95
 */
class Hak{
	int bun;
	String name;
	int[] score;
}
class HakData{
	Hak[] hak;
	int cnt;
	HakData(Hak[] hak, int cnt){
		this.hak = hak;
		this.cnt = cnt;
	}
	void dataPrint() {//자료 출력
		if(cnt==0) {
			System.out.println("종료");
		}else {
			sortScore();
			System.out.println("번호\t이름\t점수");
			for(int i=0; i<cnt; i++ ) {
				System.out.print(hak[i].bun+"\t");
				System.out.print(hak[i].name+"\t");
				for(int s=0; s<5; s++) {
					System.out.print(hak[i].score[s]+"\t");
				}
				System.out.println();
			}
		}
	}
	void sortScore() {
		int temp;
		for(int i=0; i<cnt; i++) {
			for(int s=0; s<4; s++) {
				for(int s2=s+1; s2<5; s2++) {
					if(hak[i].score[s] > hak[i].score[s2]) {
						temp = hak[i].score[s];
						hak[i].score[s] = hak[i].score[s2];
						hak[i].score[s2] = temp;
					}
				}
			}
		}
	}
	
}
public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		Hak[] hak = new Hak[10];
		
		while(cnt<10) {
			System.out.print("입력(번호,이름,점수5개) : ");
			int bun = sc.nextInt();
			if(bun==-99) {
				break;
			}
			hak[cnt] = new Hak();
			hak[cnt].bun = bun;
			hak[cnt].name = sc.next();
			hak[cnt].score = new int[5];
			hak[cnt].score[0] = sc.nextInt();
			hak[cnt].score[1] = sc.nextInt();
			hak[cnt].score[2] = sc.nextInt();
			hak[cnt].score[3] = sc.nextInt();
			hak[cnt].score[4] = sc.nextInt();
		}
		sc.close();
		HakData hakData = new HakData(hak,cnt);
		hakData.dataPrint();
		
	}

}
