package p1014;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAO { 
	public static DAO dao = new DAO();
	public static DAO getInstance() {
		return dao;
	}
	
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
	public ArrayList<VO> select() {
		ArrayList<VO> list = new ArrayList<VO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql ="select * from web_member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO vo = new VO();
				vo.setId(rs.getInt("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirth(rs.getDate("birth"));
				vo.setMail(rs.getString("mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setNickname(rs.getString("nickname"));
				list.add(vo);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
				}finally {
					try {
					if(rs!=null) { rs.close();}
					if(pstmt!=null) { pstmt.close();}
					if(conn!=null) { conn.close();}
					}catch(SQLException e) {
						e.getStackTrace();
					}
				}
		return list;
	}
	public void insert(VO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String birth = transFormat.format(vo.getBirth());

		try {
			conn= getConnection();
			String sql = "insert into web_member values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, birth);
			pstmt.setString(6, vo.getMail());
			pstmt.setString(7, vo.getPhone());
			pstmt.setString(8, vo.getAddress());
			pstmt.setString(9, vo.getNickname());
			pstmt.executeUpdate();
			System.out.println("데이터 삽입 성공");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터 삽입 실패");
		}finally {
			try {
			if(pstmt!=null) { pstmt.close();}
			if(conn!=null) { conn.close();}
			}catch(SQLException e) {
				e.getStackTrace();
			}
		}
	}
}