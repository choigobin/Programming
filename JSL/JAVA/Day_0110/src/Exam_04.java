/*	메소드의 변수는 메소드가 종료되면 사라짐
 * 
 */
public class Exam_04 {

	public static void main(String[] args) {
		int a[] = {10,20,30,40,50};
		int b=100;
		bPrint(b);
		aPrint(a);//a = a[] 배열의 첫번째 값의 주소
		
	}
	
	static void aPrint(int amugona[]) {
		//aPrint(배열의주소) amugona = 입력받은 배열의 주소가 되므로 입력받은 배열로 가서 불러온다.
		for(int x=0; x<amugona.length; x++) {
			System.out.println(amugona[x]);
		}
	}
	
	static void bPrint(int b) {
		//변수 b를 만들고 bPrint(정수)에서 입력받은 정수를 b에 넣는다.
		System.out.println(b);
	}
	
}
