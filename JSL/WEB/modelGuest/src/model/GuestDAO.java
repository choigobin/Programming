package model;

import java.sql.*;
import java.util.*;

public class GuestDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private GuestDAO() {}
	private static GuestDAO instance = new GuestDAO();
	
	public static GuestDAO getInstance() {
		return instance;
	}
	private static Connection getConnection() throws Exception {
		Connection conn;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		return conn;
	}
	private void clean() {
		try {
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 방명록 전체 자료 검색
	public List<GuestVO> selectPg(int pg){
		List<GuestVO> list = new ArrayList<GuestVO>();
		
		try {
			String sql = "select x.* from (select ROW_NUMBER() OVER (ORDER BY idx desc) as r, g.* from guest g) x "
					+ "where r BETWEEN ? and ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pg*10-9);
			pstmt.setInt(2, pg*10);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(""+rs.getDate("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		
		return list;
	}
	
	public int count(){
		int count=0;
		try {
			String sql = "select count(*) from guest";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		
		return count;
	}
	
	public GuestVO select(int idx){
		GuestVO vo = new GuestVO();
		
		try {
			String sql = "select * from guest where idx = ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(""+rs.getDate("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		
		return vo;
	}
	
	public void insert(String name,String subject,String contents) {
		try {
			String sql = "insert into guest(idx,name,subject,contents) values("+ 
					"GUEST_SEQ_IDX.nextval,?,?,?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, contents);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
	
	public void guestReadCnt(int idx) {
		try {
			String sql = "update guest set readcnt=readcnt+1 where idx = ? ";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
	
}
