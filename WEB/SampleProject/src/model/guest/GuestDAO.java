package model.guest;

import java.sql.*;
import java.util.*;
import util.*;
public class GuestDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	private static GuestDAO instance = new GuestDAO();
	private GuestDAO() {};
	
	public static GuestDAO getInstance() {
		return instance;
	}
	
	private void cleanUp() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int countGuest(){
		int cnt = 0;
		String sql = "select count(*) from guest";
		try {
			conn = DBmangaer.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cleanUp();
		}
		return cnt;
	}
	
	public List<GuestVO> selectGuest(int page){
		List<GuestVO> list = new ArrayList<GuestVO>();
		String sql = "select x.* from (select row_number() over(order by idx desc) rnum ,s.* from guest s) x where rnum between ? and ? order by rownum";
		try {
			conn = DBmangaer.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*10-9);
			pstmt.setInt(2, page*10);
			rs = pstmt.executeQuery();
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
			cleanUp();
		}
		return list;
	}
}
