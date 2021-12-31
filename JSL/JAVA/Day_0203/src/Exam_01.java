import java.util.ArrayList;

/*	Collection Framework
 * 	자바의 자료구조
 * 	Collection 인터페이스를 상속한 인터페이스 (List, Set) // Map => 상속 x
 * 	List (순서가 있고, 중복 허용) - ArrayList, Vector, LinkedList
 * 	Set (순서가 없고, 중복 불허)
 * 	Map (키, 값을 쌍으로 저장) - 순서가 있고, 키의 중복 불허
 */
public class Exam_01 {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();// == ArrayList list = new ArrayList();
		
		System.out.println("list isEmpty : "+list.isEmpty());
		System.out.println("list size : "+list.size());
		
		list.add("123");
		list.add(123);
		list.add(3.14);
		list.add('A');
		
		System.out.println("list isEmpty : "+list.isEmpty());
		System.out.println("list size : "+list.size());
		String s= (String)list.get(0);
		int a = (int)list.get(1);
		System.out.println("s = "+s);
		System.out.println("a = "+a);
		
		
		
	}
}
