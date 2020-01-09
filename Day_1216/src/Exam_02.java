
public class Exam_02 {

	public static void main(String[] args) {
		System.out.print("1234");
		System.out.print(100);
		System.out.println();//줄바꿈
		System.out.print("10+20=");
		System.out.print(10+20);
		System.out.println();
		System.out.print("10+20=" + (10+20));
		System.out.println();
		System.out.print("10+20=" + ("10"+"20"));
		System.out.println();
		System.out.println("10+20=" + 10+20);//문자열 + 숫자 => 문자열 (순서가 왼쪽부터) =>"10+20"+10 =>문자 + 20 =>문자 
		System.out.println(10+20);//30
		System.out.println(""+10+20);//1020
	}

}