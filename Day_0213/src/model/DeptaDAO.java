package model;

import java.sql.*;
import java.util.*;

public class DeptaDAO {
	DBManager db = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void clean() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//select *
	public List<DeptaVO> selectAll() {
		List<DeptaVO> list = new ArrayList<DeptaVO>();
		// 셀렉트 *
		String sql = "select * from depta";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DeptaVO vo = new DeptaVO();
				vo.setDno(rs.getInt("dno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return list;
	}
	//insert
	public void insert(int dno, String dname, String loc) {
		String sql = "insert into depta values(?,?,?)";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			clean();
		}
	}
	//select where dno=?
	public DeptaVO select(int dno) {
		DeptaVO vo = new DeptaVO();
		String sql = "select * from depta where dno=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setDno(rs.getInt("dno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return vo;
	}
	//update
	public void update(int dno, String dname, String loc) {
		String sql = "update depta set dname=?,loc=? where dno=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, dno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			clean();
		}
	}
	//delete
	public void delete(int dno) {
		String sql = "delete from depta where dno=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
}
