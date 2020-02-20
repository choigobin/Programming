package oracle.exam;
/*	키보드로 날짜입력 (예 1901-01-02)
 * 	사원정보 테이블에서 해당 날짜이후 입사한 사원 정보 출력
 */
import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜 : ");
		String date = sc.nextLine();
		sc.close();
		OracleSQL oracle = new OracleSQL();
		
		try {
			oracle.makeConn();
			oracle.empSearchDate(date);
			oracle.takeDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
