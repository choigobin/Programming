import java.util.*;
public class Exam_05 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("jsp");
		set.add("servlet");
		set.add("content");
		set.add("c++");
		set.add("Java");
		set.add("python");
		
		System.out.println("1: "+set);
		List<String> list = new ArrayList<String>(set);
		System.out.println("2: "+list);
		System.out.println("3: "+list.get(2));
		Collections.sort(list);
		System.out.println("4: "+list);
		
	}
}
