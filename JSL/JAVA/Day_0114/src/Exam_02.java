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