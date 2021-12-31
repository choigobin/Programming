package p0730;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class dbdemo {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/client?serverTimezone=UTC";
		Connection con=null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from client";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결 중...");
			con=DriverManager.getConnection(url,"root","1234");
			System.out.println("데이터베이스 연결 성공");
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("Client_id :"+rs.getString("Client_ID"));
				System.out.print("Name :"+rs.getString("Name"));
				System.out.println("address :"+rs.getString(3));
			}
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾지 못했습니다.");
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
		return con;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeConnection();
	}

}
