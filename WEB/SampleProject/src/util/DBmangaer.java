package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBmangaer {
	private DBmangaer() {};
	public static Connection getConnection() throws Exception {
		Connection conn;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		return conn;
	}
	
	
}
