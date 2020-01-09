/*	&&, & 의 차이점
 * 		: F & F -> F
 *		: F && -> F
 *		: 결국 &&이 더 빠름
 */
public class Exam_03 {
	public static void main(String[] args) {
		
		int a=7,b=5,c;
		c = (int)(a/(double)b); // 양쪽 타입이 같아야하므로 (int)필요
		System.out.println("c = "+c);
		System.out.println("7/5 = " +7/5.);
		
		c = a%b;
		System.out.println("c = "+c);
		
		// <<(*) , >>(/) : shift(이동) 연산자
		
	}

}
