/*	증가, 감소 연산자
 * 	++, -- => 단항연산자
 */
public class Exam_09 {

	public static void main(String[] args) {
		int a=5, b=0;
		//a=a+1;//1증가 == a++; ++,-- 는 무조건 1씩 증감
		b=a++;// 후위형 b=a -> ++ 진행 // b=5,a=6
		b=++a;// 전위형 a++ -> b=a // b=6,a=6
		System.out.println(b);
	}

}
