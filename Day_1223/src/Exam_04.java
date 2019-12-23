/*	배열의 선언과 동시 초기화
 * 	
 */
public class Exam_04 {
	public static void main(String[] args) {
		int[] a = {45,84,2,54,32,45,32,4,86,2,4,5};
		// 배열 길이 -> 배열이름.length
		System.out.println("배열 길이 : "+a.length);
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"] = "+a[i]);
		}
		
		
	}
}
