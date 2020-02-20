package oracle.exam;
/*	키보드로 부서번호 입력
 * 	부서번호에 해당하는 사원정보 출력
 */
import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("부서코드 : ");
		int dno = sc.nextInt();
		sc.close();
		OracleSQL oracle = new OracleSQL();
		
		try {
			oracle.makeConn();
			oracle.empSearchDno(dno);
			oracle.takeDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
