package net.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.webmvc.util.DBUtil;

public class JoinDAO {
	private JoinDAO() {}	
	private static JoinDAO instance = new JoinDAO();
	public static JoinDAO getInstance() {
		return instance;
	}
	//전체 카운트
	public int joinCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;	
		String query="select count(*) from sam_admin";
		int row=0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row=rs.getInt(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return row;
	}
	//로그인
	public int login(Connection conn, String id, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;	
		String query="select adpass from sam_admin where adid=?";
		int row = -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("adpass") != null && 
						rs.getString("adpass").equals(pass)){
					row=1;
				}else {
					row=0;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return row;
	}
	
}
