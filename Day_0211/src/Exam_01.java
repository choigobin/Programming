import java.sql.*;

/*	1. DB 연동
 * 	2. 검색
 */
public class Exam_01 {
	public static void main(String[] args) {
		// 1단계 JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로딩 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2단계 Connection 객체 생성 - 커넥션 연결
		String myURL = "jdbc:oracle:thin:@localhost:1521/xe";
		String myID = "system";
		String myPW = "1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(myURL,myID,myPW);
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3단계 SQL 사용
		Statement stmt = null;
		ResultSet rs = null; // select 구문에서만 필요
		try {
			stmt= con.createStatement();
			rs = stmt.executeQuery("select * from dept");
			while(rs.next()) {
				System.out.print(rs.getInt("dno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4단계 닫기
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
