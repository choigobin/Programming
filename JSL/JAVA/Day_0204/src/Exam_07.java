import java.util.*;
public class Exam_07 {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<String>();
		que.offer("aaa");
		que.offer("bbb");
		que.offer("ccc");
		que.offer("ddd");
		System.out.println(que.poll());
		System.out.println(que);
		
	}
}
