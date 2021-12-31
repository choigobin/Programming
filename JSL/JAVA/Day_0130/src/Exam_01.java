import java.util.Scanner;
import java.util.regex.Pattern;

/*	정규 표현식 - Pattern 클래스
 * 	\\d - 숫자, \\w - 문자 또는 숫자
 * 	\\d? - 숫자가 없음 또는 1자, \\d* - 숫자가 1자이상
 * 	\\d{3} - 숫자가 3자, \\d{1,3} - 숫자가 1~3자
 */
public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		String[] var = sc.nextLine().split(",");
		sc.close();
		for(int x=0; x<var.length; x++) {
			boolean bool = Pattern.matches("\\w*", var[x]);
			if(bool) {
				System.out.println("정상 : "+var[x]);
			}else {
				System.out.println(var[x]+" : 오류");
			}
		}
		
		
	}

}
