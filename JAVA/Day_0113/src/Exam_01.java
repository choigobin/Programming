/*
객체지향프로그래밍(OOP : Object Oriented Programming)
객체 = 사물,물체,개념,사상
ex)키보드,마우스,파워,cpu 등이 객체 이런 객체를 활용하는 것 => 사용,유지보수,확장이 쉽다.
유지보수 => 고장난 객체만 바꾸면 되니까 유지보수가 쉽다.
object = 객체
class = 객체를 만들기 위한 일종의 설계도
method = 함수

	OOP 기본 3단계
1. 객체지향 분석(object-oriented analysis : OOA)
	객체 모델링 : 속성(특징)과 기능을 정의
	속성 : 변수 / 기능 : 메소드
2. 객체지향 설계(object-oriented design : OOD)
	클래스를 생성(설계)하는 것
3. 객체지향 구현(object-oriented programming : OOP)
	설계를 토대로 코딩하는 것
	
	클래스의 구조
[접근제한자] 클래스명{ //== 클래스 헤더
	[변수,상수 정의] //== 멤버필드(멤버 변수)
	[생성자 정의]
	[메소드 정의] //== 멤버 메서드
}

멤버 변수 또는 멤버 필드는 특정 객체와 연결된 변수의 하나이며, 해당 변수는 모든 메소드(멤버 함수)에 접근이 가능하다.
클래스 기반 언어에서 이들은 두 종류로 구별된다 => 클래스(정적 멤버) 변수, 인스턴스 변수
 */

class Student{
	static int vv;//클래스 변수 => 클래스가 있는 객체 지향 프로그래밍에서 클래스 변수(class variable)는 
		//클래스의 인스턴스가 얼마나 많이 존재하는지에 관계 없이, 하나의 사본이 존재하는 클래스에 정의된 변수이다
	int studentNumber; //인스턴수변수 => 각각의 인스턴스화된 클래스의 객체가 별도의 사본이나 인스턴스를 가지고 있다.
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
		
		Student stu1; // 레퍼런스(참조) 변수 (인스턴스 변수-객체를 가리키는 변수)
		stu1 = new Student(); // 인스턴스(객체) 생성(실제로 생성) , 붕어빵 틀에서 붕어빵을 만든 느낌
		//new를 이용해서 stu1를 생성하면 객체가 만들어지고 stu1은 Student를 가리킨다.
		//배열하고 같은 원리
		stu1.studentNumber = 1101;
		//stu1.studentNumber이 가리키는 것
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