/*	관계연산자(>,<,>=,<=)연산순위동등 왼쪽부터 ->
 * 	상등연산자(==,!=) --> =(대입연산자)
 * 	결과는 True/ False 
 */
public class Exam_05 {

	public static void main(String[] args) {
		
		boolean b = 7>8;
		System.out.println("7>8 = " + (7>8));
		System.out.println("7>8 = " + b);
		int a=7+8;
		System.out.println("7+8 = " + (7+8));
		System.out.println("7+8 = " + a);
	}

}

