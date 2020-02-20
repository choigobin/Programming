import java.util.*;
public class Exam_04 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Java");
		set.add("123");
		set.add("AAAA");
		set.add("CCCC");
		System.out.println(set);
		
		for(String s : set) {
			System.out.println(s);
		}
		System.out.println("-----------");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			if(s.equals("AAAA")) {
				iter.remove();
			}
		}
		for(String s : set) {
			System.out.println(s);
		}
		
		
	}
}
