import java.util.Scanner;

/*	키보드 학생 성적정보 입력(최대 10명)
 * 	1.입력(번호 이름 국어 영어 수학)
 * 	입력 : 1 홍길동 89 80 90
 * 	입력 : 2 김자바 77 88 99
 * 	입력 : -99 --> 종료
 * 
 * 	2.출력 -1 
 * 	번호	이름	국어	영어	수학	총점	평균	석차
 * 
 * 	3.출력 -2 석차를 기준으로 출력
 * 	번호 	이름	국어	영어	수학	총점	평균 	석차
 */
public class Exam_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] score = new int[10][6];
		String[] name = new String[10];
		double[] avg = new double[10];
		int cnt=0;
		while(cnt<10) {
			System.out.print("입력 : ");
			score[cnt][0] = sc.nextInt();
			if(score[cnt][0]==-99) break;
			name[cnt] = sc.next();
			score[cnt][4] += score[cnt][1] = sc.nextInt();
			score[cnt][4] += score[cnt][2] = sc.nextInt();
			score[cnt][4] += score[cnt][3] = sc.nextInt();
			score[cnt][5] = 1;
			sc.nextLine();
			cnt++;
		}
		sc.close();
		//평균, 석차 구하기
		for(int x=0; x<cnt; x++) {
			avg[x]=(int)((score[x][4]/3.)*100+0.5)/100.;
			for(int y=0;y<cnt;y++) {
				if(score[x][4]<score[y][4]) {
					score[x][5]++;
				}
			}
		}
		// 출력 1
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
		for(int x=0; x<cnt; x++) {
			for(int y=0; y<6; y++) {
				System.out.print(score[x][y]+"\t");
				if(y==0) System.out.print(name[x]+"\t");
				if(y==4) System.out.print(avg[x]+"\t");
			}
			System.out.println();
		}
		// 석차 기준으로 오름차순 정렬
		for(int x=0; x<cnt-1; x++) {
			for(int y=x+1; y<cnt; y++) {
				if(score[x][5]>score[y][5]) {
					int temp[] = new int[6];
					for(int z=0;z<6;z++) {
						temp[z]=score[x][z];
						score[x][z]=score[y][z];
						score[y][z]=temp[z];
					}
					String box;
					box = name[x];
					name[x]=name[y];
					name[y]=box;
					double box2;
					box2 = avg[x];
					avg[x] = avg[y];
					avg[y] = box2;
				}
			}
		}
		// 출력 2
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
			for(int x=0; x<cnt; x++) {
				for(int y=0; y<6; y++) {
					System.out.print(score[x][y]+"\t");
					if(y==0) System.out.print(name[x]+"\t");
					if(y==4) System.out.print(avg[x]+"\t");
				}
				System.out.println();
			}
		
	}
}
