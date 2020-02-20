import java.util.Arrays;

/*	Arrays
 * 	- 배열복사, 항목 비교
 * 	- 정렬, 검색
 */
public class Exam_08 {
	public static void main(String[] args) {
		int[] var = {1,2,3,4,5,6};
		int[] str = Arrays.copyOf(var, 6);
		for(int x=0; x<str.length; x++) {
			System.out.print(str[x]+"\t");
		}
		System.out.println();
		System.out.println("배열 주소 비교: "+var.equals(str));
		System.out.println("배열 요소값 비교: "+Arrays.equals(var, str));
		
	}
}
