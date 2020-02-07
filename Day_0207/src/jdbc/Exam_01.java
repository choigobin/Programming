package jdbc;

import java.sql.*;

public class Exam_01 {
	public static void main(String[] args) {
		// JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//자바는 Class 라는 클래스를 활용해서 다른 클래스를 로딩할 수 있다.
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		// 커넥션 연결
		String myURL ="jdbc:oracle:thin:@localhost:1521:orcl"; // orcl == sid 이름
		String myUser = "system";
		String myPass = "1234";
		try {
			Connection con = DriverManager.getConnection(myURL,myUser,myPass);
			con.close();
			System.out.println("커넥션 연결 성공");
		} catch (Exception e) {
			System.out.println("커넥션 연결 실패");
			e.printStackTrace();
		}
		
		
		
	}
}
