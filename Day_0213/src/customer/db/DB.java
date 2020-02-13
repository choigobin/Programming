package customer.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private DB() {}
	private static DB instance = new DB();
	public static DB getInstance() {
		return instance;
	}
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw ="1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
