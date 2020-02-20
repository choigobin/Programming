package net.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.webmvc.dto.BoardVO;
import net.webmvc.dto.NoticeVO;
import net.webmvc.util.DBUtil;

public class NoticeDAO {
	private NoticeDAO() {}	
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}

	public int noticeInsert(Connection conn, NoticeVO vo) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String query="insert into sam_notice (idx,subject,contents) "
				+ "values (sam_notice_seq_idx.nextval,?,?)";
		
		int row=0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());

			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return row;
	}
	
	public int noticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select count(*) from sam_notice";
				
		int row=0;
		try {
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			if(rs.next()){
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

	public int noticeCount(Connection conn, String s_query)  {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int row = 0;

		try{
			if(s_query.equals("")) {
				query = "select count(*) as counter from sam_notice ";
			}else {
				query = "select count(*) as counter from sam_notice where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
				row = rs.getInt("counter");

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return row;
		}
	}
	
	public List<NoticeVO> noticeList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		String query="select * from sam_notice order by idx desc";
		NoticeVO vo = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return list;
		}
	}
	
	public List<NoticeVO> noticeList(Connection conn, int pagestart,int endpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query = "";
		List<NoticeVO> list=new ArrayList<NoticeVO>();
		NoticeVO vo=null;
		try{
			
			query = "select X.* from (select rownum as rnum, A.* from (" + 
					"select * from sam_notice order by regdate desc) A " + 
					"where rownum <= ?) X where X.rnum >= ? ";
			
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				vo = new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return list;
		}
	}
	
	public List<NoticeVO> noticeList(Connection conn,String s_query, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String query="";
		List<NoticeVO> list = new ArrayList<NoticeVO>();
/*		
		query = "select x.* from (select a.* from board a, ";
		query += "(select no from board where " + s_query;
		query += " order by parent desc, depth asc) b ";
		query += " where a.no=b.no and rownum < ? ";
		query += " and " + s_query + " order by parent";
		query += " desc, depth asc) x, ";
		query += "(select c.no from board c, ";
		query += "(select no from board where " + s_query ;
		query += " order by parent desc, depth asc) d ";
		query += "where c.no=d.no and rownum < ? ";
		query += " and " + s_query + " order by ";
		query += "parent asc, depth desc) y where ";
		query += "x.no=y.no and " + s_query;
		query += " order by x.parent desc, x.depth asc";
*/
		query = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from sam_notice order by regdate desc) A where " + s_query +
				" and rownum <= ?) X where " + s_query + " and X.rnum >= ?";

		NoticeVO vo = null;
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return list;
		}
	}
	
	public void noticeViewCount(Connection conn, int idx) {
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="update sam_notice set readcnt = readcnt +1  where idx = ?";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
		}
	}
	
	public NoticeVO noticeSelect(Connection conn, int idx) {

		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select * from sam_notice where idx = ?";
		NoticeVO vo = null;
		try {
		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return vo;
		}
	}
	
	public int noticeDelete(Connection conn, int idx) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		String query="delete from sam_notice  where idx = ?";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return row;
		}
	}
	
	public int noticeDelete(Connection conn, int idx, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		String query="delete from sam_notice  where idx = ? and pass = ?";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return row;
		}
	}

	public int noticeEdit(Connection conn, NoticeVO vo) {
	
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		String query="update sam_notice set subject=?, contents=? where idx=? ";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getIdx());
			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
			return row;
		}
	}
}
