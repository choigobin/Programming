package net.webmvc.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.webmvc.dto.PdsVO;
import net.webmvc.util.DBUtil;

public class PdsDAO {
	private PdsDAO() {}	
	private static PdsDAO instance = new PdsDAO();
	public static PdsDAO getInstance() {
		return instance;
	}

	public int pdsWrite(Connection conn, PdsVO vo)  {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="insert into sam_pds(idx,name,pass,email,subject,contents,filename) "
				+ "values(sam_pds_seq_idx.nextval,?,?,?,?,?,?)";
		int row=0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getFilename());
			
			row=pstmt.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return row;
	}
	
	public int pdsCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;	
		String query="select count(*) from sam_pds";
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
	
	public int pdsCount(Connection conn, String s_query)  {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int row = 0;

		try{
			if(s_query.equals("")) {
				query = "select count(*) as counter from sam_pds ";
			}else {
				query = "select count(*) as counter from sam_pds where " + s_query;
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
	
	public List<PdsVO> pdsList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		List<PdsVO> list = new ArrayList<PdsVO>();
		
		String query="select * from sam_pds order by idx desc";
		PdsVO vo = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setName(rs.getString("name"));
				vo.setFilename(rs.getString("filename"));
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
	
	public List<PdsVO> pdsList(Connection conn, int pagestart,int endpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query = "";
		List<PdsVO> list=new ArrayList<PdsVO>();
		PdsVO vo=null;
		try{
			
			query = "select X.* from (select rownum as rnum, A.* from (" + 
					"select * from sam_pds order by regdate desc) A " + 
					"where rownum <= ?) X where X.rnum >= ? ";
			
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setName(rs.getString("name"));
				vo.setFilename(rs.getString("filename"));
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
	
	public List<PdsVO> pdsList(Connection conn,String s_query, int pagestart, int endpage) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String query="";
		List<PdsVO> list = new ArrayList<PdsVO>();
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
				+ "(select * from sam_pds order by regdate desc) A where " + s_query +
				" and rownum <= ?) X where " + s_query + " and X.rnum >= ?";

		PdsVO vo = null;
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setName(rs.getString("name"));
				vo.setFilename(rs.getString("filename"));
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
	
	//
	public void pdwViewCount(Connection conn, int idx) {	
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="update sam_pds set readcnt = readcnt +1  where idx = ?";
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

	public PdsVO pdsSelect(Connection conn, int idx) {

		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String query="select * from sam_pds where idx = ?";
		PdsVO vo = null;
		try {
		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSubject(rs.getString("subject"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setFilename(rs.getString("filename"));
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
	
	//
	public int pdsDelete(Connection conn, int idx, String pass, String saveDir) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		//String saveDir="Pds/upload/";
		String query="select * from sam_pds  where idx = ? and pass = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String filename = rs.getString("filename");
				File a = new File(saveDir+filename);
				System.out.println(a.getAbsolutePath());
				
				if(a.isFile()) {
					a.delete();
				}else {
					System.out.print("File Not found");
				}
			}
			query = "delete from sam_pds where idx=? and pass =?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			row=pstmt.executeUpdate();// 
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			return row;
		}
	}
	
	//
	public int pdsEdit(Connection conn, PdsVO vo) {
	
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int row=0;
		String query="update sam_pds set email=? ,subject=?, contents=?, filename=? where idx=? and pass=? ";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setString(4, vo.getFilename());
			pstmt.setInt(5, vo.getIdx());
			pstmt.setString(6, vo.getPass());
			row = pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
			return row;
		}
	}
	
}
