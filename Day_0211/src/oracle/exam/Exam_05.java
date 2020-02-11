package oracle.exam;
/*	포함 연산자
 * 	성씨가 '김'
 * 	% -> 글자수 제한 x
 * 	_ -> 한글자만
 * 	like '김 %'
 * 	
 */
import java.util.Scanner;

public class Exam_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		sc.close();
		OracleSQL oracle = new OracleSQL();
		
		try {
			oracle.makeConn();
			oracle.nameSearch(name);
			oracle.takeDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
