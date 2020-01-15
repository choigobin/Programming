/*
멤버변수(인스턴스 변수) 초기화
1.명시적 초기화
2.생성자를 이용한 초기화
 */

/*
 			3.초기화 블럭
	 			-인스턴스 초기화 블럭 : {}
		 			>생성자에서 공통적으로 수행되는 작업에 사용
		 			>인스턴스 생성될 때마다 실행(단, 생성자보다 먼저 실행됨)
		 		-클래스(정적) 초기화 블럭 : static{}
		 			>클래스 변수의 복잡한 초기화에 사용
		 			>클래스 로딩시에 실행
 */

class AA{
	int x; // 인스턴스(객체)가 생성 될때 만들어지기 때문에 인스턴스 변수라고도 함

	static{ //정적 초기화 블럭
		System.out.println("정적 초기화 블럭");
	}
	{ //인스턴스 초기화 블럭 ( 명시적  초기화와 크게 다를게 없다.)

		System.out.println("인스턴스 초기화 블럭");
	}
	AA(){ //생성자를 이용한 초기화

		System.out.println("생성자를 이용한 초기화");
	}
	
	// 초기화 블럭 실행 순서 주의! 
	
	void data() {
		int x = 0;
	}
	
}
public class Exam_03 {
	public static void main(String[] args) {
		System.out.println("하하");
		AA a = new AA();
		
		
		
	}
}