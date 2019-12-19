/*	증감연산자
 * 	++ : 1씩 증가
 * 	-- : 1씩 감소
 */
public class Exam_01 {
	public static void main(String[] args) {
		int a=5, b;
		int aa=5, bb;
		
		b=a++;// 후위형 a=a+1 => b=a, a=a+1 => b=5,a=6
		System.out.println("a="+a);
		System.out.println("b="+b);
		bb=++aa;
		System.out.println("aa="+aa);
		System.out.println("bb="+bb);

	}

}
