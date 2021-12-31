package oracle.db;

import java.sql.*;

public abstract class OracleConn {
	private String myDriver="oracle.jdbc.OracleDriver";
	private String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String myID = "system";
	private String myPW = "1234";
	
	protected Connection myConn;
	
	public OracleConn() {}
	
	public void makeConn() throws Exception {
		Class.forName(myDriver);
		myConn = DriverManager.getConnection(myURL,myID,myPW);
		//System.out.println("드라이버로딩 & 커넥션 연결");
	}
	public abstract void cleanUp() throws Exception;
	public void takeDown() throws Exception{
		cleanUp();
		myConn.close();
		
	}
	
}
