
public class Exam_08 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
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
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}
		
		
		
	}

}
