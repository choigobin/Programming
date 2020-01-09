/*	논리연산자
 * 	!(not) -> &&(and) -> ||(or)
 * 	//!(not) => (단항연산자) 연산순위가 엄청 빠름 +- 보다 빠름
 */
public class Exam_06 {

	public static void main(String[] args) {
		System.out.println("5>4&&7<8 = " + (5>4&&7<8));
		System.out.println("5>4 = " + !(5>4));
		boolean flag = false;
		System.out.println("flag = " + !flag);
		int a = 100;
		System.out.println("a = " + a);
		//System.out.println("a = " + !a); -> 참거짓에만 !(not)을 걸 수 있다.
		int sw = 0;
		System.out.println("sw = " + (sw==0));
		System.out.println("sw = " + !(sw==0));
		System.out.println("sw = " + (sw!=0));
		System.out.println("sw = " + (sw==1));
	}

}