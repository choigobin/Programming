package model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PdsDAO {
	private PdsDAO() {}
	private static PdsDAO instance = new PdsDAO();
	public static PdsDAO getInstance() {
		return instance;
	}
	/*
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	*/
	/*
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context env = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	*/
	public List<PdsVO> pdsList(Connection conn,String type,String key,int page) {
		PreparedStatement pstmt;
		ResultSet rs;
		List<PdsVO> list = new ArrayList<PdsVO>();
		String sql = "select * from (select ROW_NUMBER() OVER (ORDER BY idx desc) rn, t.* "
				+ "from tbl_pds t where "+type+" like '%"+key+"%') where rn between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page*10-9);
			pstmt.setInt(2, page*10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PdsVO vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
				list.add(vo);
			}
		} catch (Exception e) {
			
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public PdsVO pdsSelect(Connection conn,int idx) {
		PreparedStatement pstmt;
		ResultSet rs;
		PdsVO vo = new PdsVO();
		String sql = "select * from tbl_pds where idx = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents").replace("\n", "<br>"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
			}
		} catch (Exception e) {
			
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return vo;
	}
	
	public int pdsCount(Connection conn,String type,String key) {
		PreparedStatement pstmt;
		ResultSet rs;
		int row = 0;
		String sql = "select count(*) from tbl_pds where "+type+" like '%"+key+"%'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				row=rs.getInt(1);
			}
		} catch (Exception e) {
			
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return row;
	}
	
	public int pdsWrite(Connection conn,PdsVO vo) {
		PreparedStatement pstmt;
		int row = 0;
		String sql = "insert into tbl_pds(idx,name,pass,email,subject,contents,filename) values(pds_seq_idx.nextval,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getFilename());
			row= pstmt.executeUpdate();
		} catch (Exception e) {
			
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return row;
	}
	
	public int readCnt(Connection conn,int idx) {
		PreparedStatement pstmt;
		int row = 0;
		String sql = "update tbl_pds set readcnt =readcnt+1 where idx=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row= pstmt.executeUpdate();
		} catch (Exception e) {
			
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return row;
	}
}
