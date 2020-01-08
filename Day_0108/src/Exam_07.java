
public class Exam_07 {
	public static void main(String[] args) {
		int[] bun = {5,3,1,4,2};
		int[] score= {50,70,60,90,80};
		// 번호순으로 출력
		// 1	2	3	4	5
		//60	80	70	90	50
		System.out.print("B Data : ");
		for(int x=0; x<bun.length; x++) {
			System.out.print(bun[x]+"\t");
		}
		System.out.println();
		System.out.print("S Data : ");
		for(int x=0; x<score.length; x++) {
			System.out.print(score[x]+"\t");
		}
		System.out.println();
		for(int x=0; x<bun.length-1;x++) {//기준
			for(int y=x+1;y<bun.length;y++) {
				if(bun[x]>bun[y]) {
					int temp= bun[x];
					bun[x]=bun[y];
					bun[y]=temp;
					temp=score[x];
					score[x]=score[y];
					score[y]=temp;
					
				}
			}
		}
		System.out.print("번호 :\t");
		for(int x=0; x<bun.length; x++) {
			System.out.print(bun[x]+"\t");
		}
		System.out.print("\n점수 :\t");
		for(int x=0; x<bun.length; x++) {
			System.out.print(score[x]+"\t");
		}
	}
}
