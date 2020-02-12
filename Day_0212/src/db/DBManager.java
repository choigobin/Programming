package db;
import java.sql.*;
//싱글톤
public class DBManager {
	private DBManager() {}
	private static DBManager instance = new DBManager();
	public static DBManager getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "system";
		String pw = "1234";
		
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}