import java.util.Arrays;

class Member implements Comparable<Member>{
	String name;
	Member(){}
	Member(String name){
		this.name = name;
	}
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
}
public class Exam_10 {
	public static void main(String[] args) {
		Member m1 = new Member("홍길동");
		Member m2 = new Member("김자바");
		Member m3 = new Member("이순신");
		Member[] mem = {m1,m2,m3};
		for(int x=0; x<mem.length; x++) {
			System.out.print(mem[x].name+"\t");
		}
		System.out.println();
		
		Arrays.parallelSort(mem);
		for(int x=0; x<mem.length; x++) {
			System.out.print(mem[x].name+"\t");
		}
		System.out.println();
		
	}
}
