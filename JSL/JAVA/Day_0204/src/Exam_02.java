import java.util.*;

/*	인터페이스 Set : 순서x, 중복x => 순서가 없어서 값을 꺼내올 수 없다. => .get() 메소드가 없음
 * 	- 구현 클래스 HashSet
 */
public class Exam_02 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Java");
		set.add("C");
		set.add("C++");
		set.add("Tomcat");
		set.add("Java");
		set.add("C#");
		System.out.print(set);
		System.out.println(" "+set.size()+"개");
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("C");
		list.add("C++");
		list.add("Tomcat");
		list.add("Java");
		list.add("C#");
		System.out.print(list);
		System.out.println(" "+list.size()+"개");
		
		
	}
}
