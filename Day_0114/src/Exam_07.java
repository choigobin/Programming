/*
[메소드 오버로딩]
- 메소드 "이름"은 모두 "동일" <-> 변수의 갯수, "변수"의 "타입" 은 "달라"야함
 */

class GG{
	void add (int a, int b) {
		int s = a+b;
		System.out.println("s = "+s);
	}
	void add (int ... a) { //가변인자 - 자동으로 배열 처리( 매개변수가 몇개 올지 모를때)
		int s = 0;
		for(int x = 0; x<a.length; x++) {
			s += a[x];
		}
		System.out.println("s = "+s);
	}
	void add2 (int[] arr) { //배열
		int s = 0;
		for(int x= 0; x< arr.length; x++) {
			s += arr[x];
		}
		System.out.println("s = "+s);
	}
	
	
}


public class Exam_07 {
	public static void main(String[] args) {
		
		GG g1 = new GG();
		g1.add(10,20);
		g1.add(1,2,3,4,5); // 가변인자 방식으로 값을 배열이아닌 그냥 넘겨줌
		 
		int arr[] = {1,2,3,4,5}; 
		g1.add2(arr); // 배열 방식으로 값을 배열의 형태로 넘겨줌
		
		
		
	}
}