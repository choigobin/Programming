/* 문제) 키보드로 1문자 입력
 * 		입력된 문자를 이용해서 (*) 입력된 경우
 *		    *
 *		   ***
 *		  *****
 *		 *******
 *		********* 
 */
public class Exam_06 {

	public static void main(String[] args) throws Exception{
		System.out.print("1문자 입력 : ");
		char x = (char)System.in.read();
		System.out.println("    "+x);
		System.out.println("   "+x+x+x);
		System.out.println("  "+x+x+x+x+x);
		System.out.println(" "+x+x+x+x+x+x+x);
		System.out.println(""+x+x+x+x+x+x+x+x+x);
		
	}

}
