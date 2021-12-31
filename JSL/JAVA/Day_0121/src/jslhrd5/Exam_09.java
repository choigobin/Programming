package jslhrd5;
class Student2{
	int bun;
	String name;
	int score;
	Student2(){}
	Student2(int bun, String name, int score){
		this.bun = bun;
		this.name = name;
		this.score = score;
	}
	void print() {
		System.out.println(bun+"\t"+name+"\t"+score);
	}
	@Override
	public String toString() {
		return bun+"\t"+name+"\t"+score;
	}
		
	
}
public class Exam_09 {
	public static void main(String[] args) {
		
		Student2 s1 =  new Student2(1,"홍길동",90);
		Student2 s2 =  new Student2(1,"홍길동",90);
		String str = new String("AAAA");
		System.out.println("str = "+str);
		System.out.println("s1 = "+s1);
		System.out.println("s1. = "+s1.hashCode());
		System.out.println("s2. = "+s2.hashCode());
		
		str ="AAA";
		String str2 = new String("AAA");
		System.out.println("str. :" + str.hashCode());
		System.out.println("str2. :" + str2.hashCode());

	}

}
