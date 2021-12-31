import java.util.ArrayList;
import java.util.List;

public class Exam_02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("Java");
		list.add("C++");
		list.add("Python");
		list.add("Program");
		
		String str = list.get(0);
		System.out.println("str = "+str);
		for(int x=0; x<list.size(); x++) {
			System.out.println(list.get(x));
		}
		boolean bool = list.contains("C++");
		System.out.println(bool);
		int index = list.indexOf("C++");
		System.out.println(index);
		list.set(0, "JAVA");
		System.out.println(list.get(0));
		
	}
}
