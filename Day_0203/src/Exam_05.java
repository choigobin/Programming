import java.util.*;

public class Exam_05 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("AAAA");
		list.add("BBBB");
		list.add("!!!!");
		list.add("DDDD");
		
		List<String> list2 = list;
		list2.add("FFFF");
		
		for(String str : list) {
			System.out.println(str);
		}
		System.out.println("------------------------------");
		for(int x=0; x<list.size();x++) {
			System.out.println(list.get(x));
		}
		System.out.println("-------Iterator---------");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
