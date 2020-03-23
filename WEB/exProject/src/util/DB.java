package util;

import javax.sql.*;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.*;

public class DB {
	public static Connection getConncection() throws NamingException, SQLException
	{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		BasicDataSource ds = (BasicDataSource)envContext.lookup("jdbc/orcl");
		Connection conn = ds.getConnection();
		return conn;
		//DataSource datasource = (DataSource)envContext.lookup("jdbc/orcl");
	}
	public static void main(String[] args) {
		try {
			getConncection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
