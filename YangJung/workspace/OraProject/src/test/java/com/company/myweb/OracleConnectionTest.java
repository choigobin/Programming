package com.company.myweb;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
public class OracleConnectionTest {

		// TODO Auto-generated method stub
		private static final String driver = "oracle.jdbc.driver.OracleDriver";
		private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		private static final String user = "scott";
		private static final String PW = "1234";
		@Test
		public void testConnect() throws Exception{
			Class.forName(driver);
			try(Connection con = DriverManager.getConnection(url, user, PW)){
				System.out.println(con);
				System.out.println("오라클 연결 성공");
				
			}catch(Exception e) {
				System.out.println("오라클 연결 실패");
				e.printStackTrace();
			}
		
	}

}
