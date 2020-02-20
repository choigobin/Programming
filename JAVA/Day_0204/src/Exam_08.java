import java.util.*;
/*	사용자 정의 클래스
 */
class Person{
	int bun;
	String name;
	Person(){}
	Person(int b, String n){
		bun=b;
		name=n;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bun+"\t"+name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return p.bun==bun;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return bun;
	}
}
public class Exam_08 {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		set.add(new Person(1,"AAA"));
		set.add(new Person(1,"AAA"));
		System.out.println(set);		
		
		
		
		
		
	}
}
