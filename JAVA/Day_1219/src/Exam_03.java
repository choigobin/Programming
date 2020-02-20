/*	제어문
 * 	1) if(조건식)
 * 			문장1; // if 다음에 첫번 째 ;(세미클론)에서 if문은 종료 // {} 쓰면 여러문장 사용가능
 *	       문장2;
 */
public class Exam_03 {
	public static void main(String[] args) {
		int jumsu = 80;
		if(jumsu>=80) {
			System.out.println("합격");
			System.out.println("점수 = " +jumsu);
		}
		System.out.println("프로그램 종료");
	}

}
