package projectDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	private Connection getConnection() throws SQLException{
		Connection conn=null;
		try {
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user="yangjung";
			String password="1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("드라이버 로딩 성공");
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		return conn;
	}
	public boolean insert(UserVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql ="insert into userTbl values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPwd());
			int count = pstmt.executeUpdate();
			result = (count==1);
		}catch(SQLException e) {
			e.printStackTrace();
				}finally {
					try {
					if(conn!=null) { conn.close();}
					if(pstmt!=null) { pstmt.close();}
					}catch(SQLException e) {
						e.getStackTrace();
					}
				
			}
		return result;
			
		}
	}