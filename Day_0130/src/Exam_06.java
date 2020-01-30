/*	배열 복사
 * 	System.arraycopy(원본배열,시작위치,대상배열,시작위치,항목수);
 */
public class Exam_06 {
	public static void main(String[] args) {
		char arr1[] = {'가','나','다','라'};
		char arr2[] = {'a','b','c','d','e','f'};
		System.out.println("원본배열 출력");
		System.out.print("arr1: ");
		for(char ch : arr1) {
			System.out.print(ch +"\t");
		}
		System.out.println();
		System.out.print("arr2: ");
		for(char ch : arr2) {
			System.out.print(ch +"\t");
		}
		System.out.println();
		//배열 복사
		System.arraycopy(arr1, 0, arr2, 2, 4);
		System.out.print("arr2: ");
		for(char ch : arr2) {
			System.out.print(ch +"\t");
		}
		System.out.println();

		
	}
}
