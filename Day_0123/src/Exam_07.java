/*	1 ~ 45 로또 게임 만들기
 * 	
 * 	ex) 43 12 23 3 5 7 //중복 안되게
 */
public class Exam_07 {
	public static void main(String[] args) {
		int lotto[] = new int[6];
		int cnt = 0;
		while(cnt<6) {
			int a = (int)(Math.random()*45+1);
			lotto[cnt] = a;
			cnt++;
			for(int i=0; i<cnt-1; i++) {
				if(a==lotto[i]) {
					cnt--;
					break;
				}
			}
		}
		for(int i=0; i<6; i++) {
			System.out.print(lotto[i]+" ");
		}
		
		
	}

}
