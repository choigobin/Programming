import java.util.*;
class Student{
	int sno;
	String name;
	Student(){}
	Student(int sno, String name){
		this.sno = sno;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student st = (Student)obj;
			return st.sno == sno;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
public class Exam_13 {
	public static void main(String[] args) {
		Map<String, Student> map = new HashMap<String, Student>();
		
		map.put("A", new Student(1,"AAAA"));
		map.put("B", new Student(2,"BBBB"));
		map.put("C", new Student(3,"CCCC"));
		map.put("A", new Student(1,"AAA"));
		
		System.out.println("map size : "+map.size());
		
		Map<Student, Integer> map2 = new HashMap<Student, Integer>();
		
		map2.put(new Student(1,"AAA"), 100);
		map2.put(new Student(2,"BBB"), 90);
		map2.put(new Student(3,"CCC"), 80);
		map2.put(new Student(1,"AAA"), 70);
		
		System.out.println("map2 size : "+map2.size());
		
	}
}
