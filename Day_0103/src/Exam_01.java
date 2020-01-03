/*	for(초기값; 조건식; 증감식){
 * 		문장;
 * 		반복횟수가 정해져 있을 때 for 문이 효과적!
 * 	}
 * 
 */
public class Exam_01 {
	public static void main(String[] args) {
		
		// 1 ~ 10 출력
		int i = 0;	
		while(true) {
			i++;
			System.out.println(i);
			if(i==10) {
				break;
			}
		}
			
		while(i<10) {
			i++;
			System.out.println(i);
		}
		
		for(int x = 1; x <= 10; x++) {
			System.out.println(x);
		}
			
	}

}