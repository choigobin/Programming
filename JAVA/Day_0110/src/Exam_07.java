/*	참조에 의한 호출
 */
public class Exam_07 {

	public static void main(String[] args) {
		int a[] = {10,20};
		System.out.println("a[0]=" +a[0]);
		System.out.println("a[1]=" +a[1]);
		System.out.println("-----교환 후 -----");
		//a, b 교환
		swap(a);	
		System.out.println("a[0]=" +a[0]);
		System.out.println("a[1]=" +a[1]);
		
	}
	//교환 메소드 => 참조에 의한 호출 => swap 됨
	static void swap(int[] a) {
		int c = a[0];
		a[0] = a[1];
		a[1] = c;
	}
}
