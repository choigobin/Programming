/*	1 ~ 10 합계 출력
 * 	출력 : 1 ~ 10 = 55
 * 	리턴타입 x, 매개변수 x
 */
public class Exam_02 {
	
	public static void main(String[] args) {
		sum();
		
		
	}
	static void sum() {
		int sum = 0;
		for(int k=1; k<11; k++) {
			sum +=k;
		}
		System.out.println("출력 : 1 ~ 10 = "+sum);
		
	}
}
