package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	private DBManager() {}
	private static DBManager instance = new DBManager();
	public static DBManager getInstance() {
		return instance;
	}
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
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
