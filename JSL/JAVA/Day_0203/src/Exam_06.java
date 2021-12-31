import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam_06 {

	public static void main(String[] args) {
		List<String> str = new ArrayList<String>();
		str.add("김자바");
		str.add("홍길동");
		str.add("Java");
		str.add("1234");
		str.add("Korea");
		
		for(String s : str) {
			System.out.print(s+" ");
		}
		
		Collections.sort(str); //기본자료형,String 만 sort 가능
		System.out.println();
		for(String s : str) {
			System.out.print(s+" ");
		}
		
	}

}
