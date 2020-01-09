
public class Exam_04 {
	public static void main(String[] args) {
		
		// 삼항 연산자 (조건 연산자)
		// (조건식) ? 참 : 거짓;
		
		int a = (10>5) ? 10:5;
		// 참:거짓 조건에 맞는 값을 변수에 대입한다.
		
		System.out.println("10>5 = "+a);
		
		int aa=11, bb=8;
		
		int max = (aa>bb) ? aa:bb;
		int min = (aa>bb) ? bb:aa;
		
		System.out.println("큰 값 : "+ max);
		System.out.println("작은 값 : "+ min);
		

	}

}
