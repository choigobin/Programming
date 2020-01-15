/*
[학생 클래스 정의]
결국 클래스는 "사용자 정의변수(자료형)"
 */

class Student{
	int studentNumber;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave; // 여기 까지 속성 정의
	
	void totAccount() { // 총점 계산용 메서드
		tot = kor+eng+mat;
	}
	void aveAccount() { // 평균 계산용 메서드
		ave = tot /3.;
	}
	void dataPrint() {
		System.out.println("[성적표]");
		System.out.print("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println();
		System.out.print(studentNumber+"\t"+name+"\t"+kor+"\t");
		System.out.print(eng+"\t"+mat+"\t"+tot+"\t");
		System.out.println(ave);
	}
	
}

public class Exam_01 {
	public static void main(String[] args) {
		
		Student stu1; // stu1 = "레퍼런스(참조) 변수" (인스턴스 변수-객체를 가리키는 변수)
		stu1 = new Student(); // 인스턴스(객체) 생성(실제로 생성) , 붕어빵 틀에서 붕어빵을 만든 느낌
		//new를 이용해서 stu1를 생성하면 객체가 만들어지고 stu1은 Student를 가리킨다.
		//배열하고 같은 원리
		stu1.studentNumber = 1101;
		//stu1.studentNumber이 가리키는 놈
		stu1.name = "홍길동";
		stu1.kor = 90;
		stu1.eng = 80;
		stu1.mat = 70;
		
		stu1.totAccount();
		stu1.aveAccount();
		stu1.dataPrint();
		
		
		
		Student stu2 = new Student(); // 선언과 생성을 동시에 진행
		stu2.dataPrint();
		
		
		
		String str; 
		str="aaa";
		int a; // 변수 
		a= 10;
		
	
		
		
	}
}