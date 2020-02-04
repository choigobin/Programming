import java.util.*;
public class Exam_03 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(new Integer(1));
		set.add(new Integer(0));
		set.add(new Integer(3));
		set.add(new Integer(4));
		set.add(new Integer(5));
		set.add(new Integer(6));
		System.out.println(set);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}
}
