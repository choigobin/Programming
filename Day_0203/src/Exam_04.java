import java.util.*;

public class Exam_04 {
	public static void main(String[] args) {
		Vector<Object> vc = new Vector<Object>();
		vc.add("AAAA");
		vc.add(0,"BBB");
		vc.add("CCCC");
		for(int x=0; x<vc.size(); x++) {
			System.out.println(vc.get(x));
		}
		
		
	}
}
