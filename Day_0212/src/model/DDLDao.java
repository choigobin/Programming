package model;

import java.sql.*;
import java.util.*;

import db.DBManager;

public class DDLDao {
	DBManager manager = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//메소드 정의
	public void tabCreate() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table aaa(");
		sql.append("dno number(2),");
		sql.append("dname varchar2(10) not null,");
		sql.append("regdate date,");
		sql.append("score number(3), ");
		sql.append("primary key(dno))");

		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//등록 메소드 정의
	public int insertAAA(int dno,String dname, String regdate, int score) {
		int row = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("insert into aaa(dno,dname,regdate,score) ");
		sql.append("values(?,?,?,?)");
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, dno);
			pstmt.setString(2, dname);
			pstmt.setString(3, regdate);
			pstmt.setInt(4, score);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int updateAAA(int dno,String dname, int score) {
		int row = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("update aaa set dname=?, score=? where dno=?");
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dname);
			pstmt.setInt(2, score);
			pstmt.setInt(3, dno);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int deleteAAA(int dno) {
		int row = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("delete from aaa where dno=?");
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, dno);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
}
