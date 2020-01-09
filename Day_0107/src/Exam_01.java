
public class Exam_01 {
	public static void main(String[] args) {
		int[] score; //배열 선언 -> 자동으로 초기화
		score = new int[10]; //할당(메모리공간 확보)
		score[0]=10;
		score[1]=20;
		//score[10]=100; //-> 컴파일에러 안남! 런타임 오류 -> 찾기어려움 
		System.out.println(score);
		System.out.println(score[0]);
		System.out.println(score.length);
		
		
		
		
	}
}
