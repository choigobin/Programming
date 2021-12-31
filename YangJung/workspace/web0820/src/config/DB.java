package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection dbCon() {
		Connection conn = null;
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "yangjung";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			System.out.println("oracle 드라이버 호출 성공...");
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return conn;
	}
}
