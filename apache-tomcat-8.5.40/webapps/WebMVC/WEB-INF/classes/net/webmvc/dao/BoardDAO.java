package net.webmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.webmvc.dto.BoardVO;
import net.webmvc.util.DBUtil;

public class BoardDAO {
	private BoardDAO() {}	
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}

	public int boardInsert(Connection conn, BoardVO board) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String query="insert into sam_board (idx,name,email,subject,contents,"
				+ "pass,readcnt) values (sam_board_seq_idx.nextval,?,?,?,?,?,?)";
		int row=0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContents());
			pstmt.setString(5, board.getPass());
			pstmt.setInt(6, 0);

			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return row;
	}
	

	public int boardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select count(*) from sam_board";
				
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

		public int boardCount(Connection conn, String s_query)  {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String query = "";
			int row = 0;

			try{
				if(s_query.equals("")) {
					query = "select count(*) as counter from sam_board ";
				}else {
					query = "select count(*) as counter from sam_board where " + s_query;
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
	
	public List<BoardVO> boardList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String query="select * from sam_board order by idx desc";
		BoardVO board = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				
				list.add(board);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return list;
		}
	}
	
	public List<BoardVO> boardList(Connection conn, int pagestart,int endpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query = "";
		List<BoardVO> list=new ArrayList<BoardVO>();
		BoardVO board=null;
		try{
			
			query = "select X.* from (select rownum as rnum, A.* from (" + 
					"select * from sam_board order by regdate desc) A " + 
					"where rownum <= ?) X where X.rnum >= ? ";
			
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				list.add(board);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return list;
		}
	}
	
	public List<BoardVO> boardList(Connection conn,String s_query, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String query="";
		List<BoardVO> list = new ArrayList<BoardVO>();
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
				+ "(select * from sam_board order by regdate desc) A where " + s_query +
				" and rownum <= ?) X where " + s_query + " and X.rnum >= ?";

		BoardVO board = null;
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
				
				list.add(board);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return list;
		}
	}
	
	public void boardViewCount(Connection conn, int idx) {
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="update sam_board set readcnt = readcnt +1  where idx = ?";
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
	
	public BoardVO boardSelect(Connection conn, int idx) {

		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select * from sam_board where idx = ?";
		BoardVO board = null;
		try {
		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setSubject(rs.getString("subject"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcnt(rs.getInt("readcnt"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return board;
		}
	}
	
	public int boardDelete(Connection conn, int idx, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		String query="delete from sam_board  where idx = ? and pass = ?";
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
	
	public int boardEdit(Connection conn, BoardVO board) {
	
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		String query="update sam_board set email=?, subject=?, contents=? where idx=? and pass=?";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getEmail());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContents());
			pstmt.setInt(4, board.getIdx());
			pstmt.setString(5, board.getPass());
			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
			return row;
		}
	}
}
