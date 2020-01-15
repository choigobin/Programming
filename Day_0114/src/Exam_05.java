class DD{
	//인스턴스 변수와 정적 변수의 차이점을 확실하게 숙지하자
	static int cnt = 0; // 처음에 한번만(클래스가 로딩 될때) 초기화됨
	int m = 0;
	
	void add() {
		cnt++;
		m++;
		System.out.println("cnt = " + cnt);
		System.out.println("m = " + m);
	}
	void add2() {
		
	}
}


public class Exam_05 {
	public static void main(String[] args) {
		
		DD d1 = new DD();
		d1.add();
		System.out.println("===============");
		DD d2 = new DD();
		d2.add();
		
		
		
		
		
		
	}
}