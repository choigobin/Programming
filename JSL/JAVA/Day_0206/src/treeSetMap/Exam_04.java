package treeSetMap;
import java.util.*;

/*	Compareable 인터페이스 (디폴트 - 오름차순)
 * 	Compareator 인터페이스
 */
class Person implements Comparable<Person>{
	String name;
	int age;
	Person(){}
	Person(String n, int a){
		name=n;
		age=a;
	}
	@Override
	public int compareTo(Person o) {
		if(age < o.age) {
			return -1; //비교하는 값이 크면
		}else if(age == o.age) {
			return 0;
		}else {
			return 1;
		}
		
	}
	@Override
	public String toString() {
		return name+" - "+age;
	}
	
}
public class Exam_04 {
	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>();
		set.add(new Person("홍길동", 28));
		set.add(new Person("김자바", 30));
		set.add(new Person("이말자", 25));
		set.add(new Person("오바마", 31));

		System.out.println(set);

		Iterator<Person> iter = set.iterator();
		while(iter.hasNext()) {
			Person p = iter.next();
			System.out.println(p);
		}
		
		
		
	}
}
