package model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ModelDao {
	 private ModelDao() {}
	 private static ModelDao instance = new ModelDao();
	 static public ModelDao getDao() {
		 return instance;
	 }
	 
	 public Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			//ClassforName.() 처럼 '이름'으로 object retrieve 해주는 함수 lookup()
			DataSource dbcp = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			//POOL 안에서 연결 객체를 하나 얻어내는 코드 
			conn = dbcp.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	 }
	 
}
