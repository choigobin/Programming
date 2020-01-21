package jslhrd5;
class Student{
	int hakbun;
	String name;
	int score;
	Student(){}
	Student(int bun, String name, int score){
		this.hakbun = bun;
		this.name = name;
		this.score = score;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			//return hakbun==((Student)obj).hakbun && name.equals(((Student)obj).name);
			return hakbun==((Student)obj).hakbun && name==((Student)obj).name;
		}else {
			return super.equals(obj);
		}
		
	}
}
public class Exam_08 {
	public static void main(String[] args) {
		
		Student s1 = new Student(1,"홍길동",90);
		Student s2 = new Student(1,"김자바",90);
		System.out.println("s1 = 1,홍길동,90 // s2 = 1,김자바,90");
		if(s1.equals(s2)) {
			System.out.println("s1==s2 : " + true);
		}else {
			System.out.println("s1!=s2 : " + false );
		}
	
		s2 = new Student(1,"홍길동",50);
		System.out.println("s1 = 1,홍길동,90 // s2 = 1,홍길동,50");
		if(s1.equals(s2)) {
			System.out.println("s1==s2 : " + true);
		}else {
			System.out.println("s1!=s2 : " + false );
		}
		String s3 = "홍길동";
		String s4 = new String("홍길동");
		System.out.println(s1.name==s2.name);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3==s4);
	}

}
