/*	1 ~ ? 합계 출력
 * 	출력 : 1 ~ ? = xx
 * 	리턴타입 x, 매개변수 o
 */
public class Exam_03 {
	
	public static void main(String[] args) {
		sum(100);
		
		
	}
	static void sum(int x) {
		int sum = 0;
		for(int k=1; k<x+1; k++) {
			sum +=k;
		}
		System.out.println("출력 : 1 ~ "+x+" = "+sum);
		
	}
}
