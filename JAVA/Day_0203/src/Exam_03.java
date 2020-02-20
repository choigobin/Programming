import java.util.*;

class AA{
	int b;
	String n;
	AA(){}
	AA(int b, String n){
		this.b = b;
		this.n = n;
	}
	@Override
	public String toString() {
		return "번호 : "+b+"이름 : "+n;
	}
}
public class Exam_03 {
	public static void main(String[] args) {
		List<AA> list = new ArrayList<AA>();
		list.add(new AA(1,"AAA"));
		list.add(new AA(2,"BBB"));
		list.add(new AA(3,"CCC"));
		list.add(new AA(4,"DDD"));
		
		for(int x=0; x<list.size(); x++) {
			AA a = list.get(x);
			System.out.println(a);
		}
		
		
	}
}
