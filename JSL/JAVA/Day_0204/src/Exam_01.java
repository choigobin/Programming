import java.util.*;

/*	List -> ArrayList, Vector, LinkedList => 순서 o, 중복 o
 * 	ArrayList, Vector -> 구조가 배열과 같음 ㅁ ㅁ ㅁ ㅁ => 데이터를 중간에 삽입할 때 그 뒤에 데이터를 모두 뒤로 밀어야한다.
 * 	LinkedList -> a(주소) => aㅁa aㅁa aㅁa aㅁa => 데이터를 중간에 삽입할 때 주소만 서로 바꿔서 이어주면된다.
 * 	
 */
public class Exam_01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		list.add("123");
		list2.add("AAA");
		
		
		
	
	}
}
