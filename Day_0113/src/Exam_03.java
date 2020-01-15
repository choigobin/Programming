class AA{ // 기능(메서드)가 없는 클래스
	int x; //멤버변수(인스턴스변수) , 객체 생성시 같이 생성
	int y;
}

class BB{ // 속성이 없는 클래스
	int sum() {
		int x = 100; // 지역 변수 -> 메서드가 호출될때 생성!! , 메서드가 끝나면 없어짐
		return x;
	}
	void test(int n) { // n = 매개변수 (인자)
		System.out.println("n = "+n);
	}
}

public class Exam_03 {
	public static void main(String[] args) {
		
		int a; // 변수  (얘도 결국 main의 지역변수)
		AA aa = new AA();
		BB bb = new BB();
		
		aa = new AA(); // 이렇게 되면 기존AA말고 새로운AA가 생겨서 그걸 가리킨다.
					   // 그럼 기존 꺼는 안지워지고 그대로 있다. 이경우 자바는 GC가 알아서 지운다.
		
		aa.x = 10;
		int s = bb.sum();
		System.out.println(s);

		
		//
		
		
	}
}