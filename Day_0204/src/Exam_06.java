import java.util.*;
public class Exam_06 {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("AAAA");
		s.push("BBBB");
		s.push("CCCC");
		s.push("DDDD");
		System.out.println(s);
		System.out.println("----------------");
		System.out.println(s.peek());
		System.out.println(s);
		System.out.println("----------------");
		System.out.println(s.pop());
		System.out.println(s);
	}
}
