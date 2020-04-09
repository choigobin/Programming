package model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	 Connection conn;
	 PreparedStatement pstmt;
	 ResultSet rs;
	 
	 private Connection getConnection() {
		 return ModelDao.getDao().getConnection();
	 }
	 private void cleanUp() {
		 try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 public int insertMember(MemberVO vo) {
		 int result = 0;
		 String sql = "insert into PP_Member(userid,userpw,name,phone,email) values(?,?,?,?,?)";
		 try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cleanUp();
		}
		 return result;
	 }
	 
	 public MemberVO selectMember(String userid) {
		 MemberVO vo = new MemberVO();
		 String sql = "select * from PP_Member where userid = ?";
		 try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				vo.setName(rs.getString("name"));
				vo.setGrade(rs.getString("grade"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cleanUp();
		}
		 return vo;
	 }
	 
	 public MemberVO selectMember(String userid,String userpw) {
		 MemberVO vo = new MemberVO();
		 String sql = "select * from PP_Member where userid = ? and userpw = ?";
		 try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				vo.setName(rs.getString("name"));
				vo.setGrade(rs.getString("grade"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cleanUp();
		}
		 return vo;
	 }
	 
}
