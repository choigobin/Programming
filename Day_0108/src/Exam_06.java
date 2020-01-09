
public class Exam_06 {
	public static void main(String[] args) {
		int[] score= {50,70,60,90,80,77,45,78};
		System.out.print("Data : ");
		for(int x=0; x<score.length; x++) {
			System.out.print(score[x]+" ");
		}
		System.out.println();
		for(int x=1; x<score.length;x++) {//기준
			for(int y=0;y<score.length-x;y++) {//bubble기법
				if(score[y]>score[y+1]) {
					int temp=score[y];
					score[y]=score[y+1];
					score[y+1]=temp;
				}
			}
		}
		System.out.print("bubble : ");
		for(int x=0; x<score.length; x++) {
			System.out.print(score[x]+" ");
		}
		
	}
}

