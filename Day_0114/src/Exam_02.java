/*
[객체 지향 프로그래밍(OOP)]
1.클래스 : 추상화개념(속성-멤버변수, 행위(기능)-메서드)
2.인스턴스(객체) : 클래스로 부터 만들어진 객체
3.메시지(메소드) : 객체들간의 상호작용을 위해 사용
# 용어가 시험에 자주나옴 주의
[객체 지향 3요소]
1.캡슐화 : 클래스 내부에 정의된 것을 외부에서 메서드를 이용해서 접근 (데이터 은닉->private)
2.상속성 : 부모클래스로 부터 물려받는것
3.다형성 : 이름은 같은데 기능이 다름
	+오버라이딩 : 부모로 부터 물려 받았지만 특성이 다름(상속관계에서만 존재하는것)
			      조상클래스로 부터상속받은 메서드의 내용을 상속받은 클래스에 맞게 '변경하는것'
	+오버로딩 : 하나의 클래스에 같은 이름의 메서드를 여러개 정의하는 것
 */

/*
[마우스 객체 모델링]
-속성 : 버튼의 갯수 , 유/무선, 색상 
-기능 : 왼쪽버튼 클릭, 왼쪽버튼 더블클릭, 오른쪽버튼 클릭
 */

class Mouse2{
	//속성 정의(멤버변수)
	int btnNum = 2; //버튼갯수
	boolean wifi = true; //유선(false)무선(true)여부
	String color = "Black"; //색상
	
	//생성자
	Mouse2(){}
	Mouse2(int btnNum, boolean wifi, String color){
		this.btnNum = btnNum;
		this.wifi = wifi;
		this.color = color;		
	}
	
	//자기자신을 출력
	void mousePrint() {
		System.out.println("========================");
		System.out.println("버튼 갯수 : " + this.btnNum);
		System.out.println("유무선 여부 : " + this.wifi);
		System.out.println("색상 : " + this.color);
		System.out.println("========================");
	}
	
	//버튼 클릭 메소드
	//버튼이 2개 일때(1-왼쪽, 2-오른쪽)
	//버튼이 3개 일때(1-왼쪽, 2-오른쪽, 3-휠)
	void buttonClick(int btn) {
		if(this.btnNum<1) {
			System.out.println("오류");
			return;
		}
		if(btn == 1) {
			System.out.println("왼쪽버튼 클릭");
			return;
		}
		if(this.btnNum == 1 && btn == 2) {
			System.out.println("오른쪽 버튼 없음 에러");
		}
		if(btn==2 && this.btnNum > 1) {
			System.out.println("오른쪽버튼 클릭");
			return;
		}
		if(this.btnNum == 2 && btn == 3) {
			System.out.println("휠 버튼 없음 에러");
		}
		if(btn==3 && this.btnNum > 2) {
			System.out.println("휠 버튼 클릭");
			return;
		}
		
	}

	
	
	
	
}


public class Exam_02 {
	public static void main(String[] args) {

		Mouse2 m1 = new Mouse2(2,true,"Black");
		m1.mousePrint();
		m1.buttonClick(3);
		
		Mouse2 m2 = new Mouse2(3,false,"Red");
		m2.mousePrint();
		m2.buttonClick(3);
		
		Mouse2 m3 = new Mouse2(1,true,"white");
		m3.mousePrint();
		m3.buttonClick(2);
		
		
				
			
	}
}