/*
[객체 지향 프로그래밍(OOP)]
1.클래스 : 추상화개념[정의] => (속성-멤버변수, 행위(기능)-메서드)
2.인스턴스(객체) : 클래스로 부터 만들어진 객체(object)
3.메시지(메소드) : 객체들간의 상호작용을 위해 사용
# 용어가 시험에 자주나옴 주의
[객체 지향 3요소]
1.캡슐화 : 객체가 실제 데이터를 어떻게 처리하는지 알 수 없다는 의미(데이터 은닉->private)
		클래스를 작성할 때 작성자는 숨겨야하는 정보와 공개해야하는 정보를 구분하여 기술 가능
   		-> 객체를 사용하는 사람은 객체 중에 공개하는 정보에만 접근 가능
2.상속성 : 부모클래스로 부터 물려받는것
3.다형성 : 이름은 같은데 기능이 다름
	+오버라이딩 : 부모로 부터 물려 받았지만 특성이 다름(상속관계에서만 존재하는것)
			      조상클래스로 부터상속받은 메서드의 내용을 상속받은 클래스에 맞게 '변경하는것'
			오버라이딩 => 메서드이름,매개변수(타입),리턴(타입)이 같아야함
	+오버로딩 : 하나의 클래스에 같은 이름의 메서드를 여러개 정의하는 것
			오버로딩 => 메서드이름이 같아야함, 매개변수(타입)이 달라야함, 리턴은 상관없음

ex)
[마우스 객체 모델링]
-속성 : 버튼의 갯수 , 유/무선, 색상 
-기능 : 왼쪽버튼 클릭, 왼쪽버튼 더블클릭, 오른쪽버튼 클릭
 */

class Mouse{
	//속성 정의(멤버변수)
	private int btnNum = 2; //버튼갯수
	private boolean wifi = true; //유선(false)무선(true)여부
	private String color = "Black"; //색상
	
	//생성자(클래스 이름과 똑같은 메서드) 정의 , 생성자 오버로딩
	//생성자 사용 목적 -> 객체 생성시 초기화도 함께 하기위해
	Mouse() {}
	Mouse(int btnNum){
		this.btnNum = btnNum;
	}
	Mouse(int btnNum,boolean wifi){
		this.btnNum = btnNum;
		this.wifi = wifi;
	}
	Mouse(int btnNum,boolean wifi, String color){
		this.btnNum = btnNum;
		this.wifi = wifi;
		this.color = color;
	}
	
	public void setBtnNum(int btnNum) {
		this.btnNum = btnNum;
	}
	
	//기능 정의
	void leftClick() {
		System.out.println("왼쪽 버튼이 클릭 되었습니다.");
	}
	void rightClick() {
		System.out.println("오른쪽 버튼이 클릭 되었습니다.");
	}
	int doubleClick() {
		System.out.println("왼쪽 버튼이 더블 클릭 되었습니다.");
		return 1;
	}
	//자신을 출력
	void mPrint() {
		System.out.println("버튼 갯수 : " + this.btnNum);
		System.out.println("색상 : " + this.color);
		if(this.wifi) {
			System.out.println("유무선 여부 : 무선");
		}else System.out.println("유무선 여부 : 유선");
		System.out.println("=====================");
	}
	
	
}


public class Exam_01 {
	public static void main(String[] args) {
		// 1. 객체생성 
		Mouse mou1; // 인스턴스(레퍼런스,참조)변수 선언
		mou1 = new Mouse(); // new를 이용한 객체생성
		mou1.setBtnNum(5);
		mou1.mPrint();	
		
		Mouse mou2 = new Mouse(4);
		mou2.mPrint();		
		
		Mouse mou3 = new Mouse(10,false);
		mou3.mPrint();
		
		Mouse mou4 = new Mouse(10,false,"Red");
		mou4.mPrint();
		
				
			
	}
}
