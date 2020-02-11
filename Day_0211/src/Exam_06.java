import java.sql.*;
import java.util.Scanner;
/*	키보드로 부서번호를 입력해서 검색
 */
public class Exam_06 {
	public static void main(String[] args) {
		String myURL = "jdbc:oracle:thin:@localhost:1521/xe";
		String myID = "system";
		String myPW = "1234";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호 : ");
		int bun = sc.nextInt();
		sc.close();
		try {
			String sql = "select * from emp where dno=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로딩 성공");
			con = DriverManager.getConnection(myURL,myID,myPW);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bun);
			
			rs = pstmt.executeQuery();
			
			System.out.println("ENO\tENAME\tJOB\t\tMANAGER\tHIREDATE\t\tSALARY\tCOMMISSION\tDNO");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				if(rs.getString(3).length()>7) {
					System.out.print(rs.getString(3)+"\t");
				}else {
					System.out.print(rs.getString(3)+"\t\t");
				}
				System.out.print(rs.getInt(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getInt(6)+"\t");
				System.out.print(rs.getInt(7)+"\t\t");
				System.out.print(rs.getInt(8)+"\n");

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
