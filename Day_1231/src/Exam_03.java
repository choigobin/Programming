/*	문자 1자리 입력
 * 	'1' -> '+' , '2' -> '-', '3' -> '*', '4' -> '/'
 * 	기타입력은 'error' 처리
 */
public class Exam_03 {
	public static void main(String[] args) {
		char ch='3';
		switch(ch) {
		case '1':
			System.out.print("+");
			break;
		case '2':
			System.out.print("-");
			break;
		case '3':
			System.out.print("*");
			break;
		case '4':
			System.out.print("/");
			break;
		default:
			System.out.print("error");
		}
		
		
		
		
		
	}
}
