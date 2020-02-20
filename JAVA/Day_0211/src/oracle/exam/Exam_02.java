package oracle.exam;

import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("부서코드 : ");
		int dno = sc.nextInt();
		sc.close();
		OracleSQL oracle = new OracleSQL();
		
		try {
			oracle.makeConn();
			oracle.deptSearchDno(dno);
			oracle.takeDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
