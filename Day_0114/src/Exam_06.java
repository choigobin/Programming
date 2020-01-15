/*
[생성자]
1. 생성자 오버 로딩
2. 생성자 호출 : this() , this
 */

class EE{
	int x;
	int y;
	EE(){
		this(100);
		System.out.println("default 생성자 호출");
//		this(100,200);     -> 첫줄에 딱 한번 호출 가능함
	}
	EE(int x){
		this(x,200);
		this.x = x;
		System.out.println("매개 변수 1개 생성자 호출");
	}
	EE(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("매개 변수 2개 생성자 호출");
	}
}


public class Exam_06 {
	public static void main(String[] args) {
		
		EE e1 = new EE();
		System.out.println("x = "+e1.x);
		System.out.println("y = "+e1.y);
		
		
		
		
	}
}