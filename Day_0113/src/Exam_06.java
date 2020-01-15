class Point{
	int x; // 명시적 초기화
	int y;

	
	Point(){ // "디폴트 생성자"는 우리가 안해도 자동으로 만들어짐
		     // 클래스 이름과 똑같은 메서드 = "생성자!"
		     // 그래서 생성자를 쓸려면 이거 써줘야됨 
		System.out.println("AA");
	}
	Point(int a){ // 이렇게 생성자를 만들면 무조건 위에 "디폴트 생성자"를 만들어 줘야됨
		x = a;
		System.out.println("AAA");
	}
	Point(int a,int b){ // 위와 매개변수의 "갯수"가 다른경우
		x = a;
		y = b;
		System.out.println("AAAA");
	}
	Point(int a,double b){ // 위와 매개변수의 "종류"가 다른경우
		x = a;
		double c = b;
		System.out.println("AAAA");
	}
	
	//위 처럼 똑같은 이름의 메서드가 여러개 생성되는것을 "오버로딩"
	//메서드 이름은 "무조건" 똑같고 매개변수(갯수,종류)는 다르다!
	//이것이 오버로딩의 규칙
	
	//메서드와 생성자의 차이점은?
	//-> 생성자는 리턴타입과 접근제어자가 없다.
	
}

public class Exam_06 {
	public static void main(String[] args) {
		
		
		Point p1 = new Point(); // 클래스 만들  Point(); 메서드 없었는데 어떻게? -> 디폴트 생성자라서 그렇다.
		Point p2 = new Point(400);
		Point p3 = new Point(100,200);
		

		p1.x = 10; //값을 초기화
		System.out.println("p1.x = "+p1.x);
		System.out.println("p2.x = "+p2.x);
		System.out.println("p3.x = "+p3.x);
		System.out.println("p3.y = "+p3.y);
		
		
		
		
		
		
		
	}
}