package customer.model;

import java.sql.*;
import java.util.*;

import customer.db.DB;

public class DAO {
	DB db = DB.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<DTO> list = null;
	private void clean() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// select count(*) from custom
	public int count() {
		int answer = 1;
		String sql = "select count(*) from custom";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				answer += rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return answer;
	}
	
	// select *
	public List<DTO> select(){
		list = new ArrayList<DTO>();
		String sql = "select * from custom order by num";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setOffice(rs.getString("office"));
				dto.setBirthday(""+rs.getDate("birthday"));
				dto.setSex(rs.getString("sex"));
				dto.setIndate(""+rs.getDate("indate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return list;
	}
	// insert into
	public void insert(DTO dto){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into custom(num,name,tel,addr,office,birthday,sex) ");
		sql.append("values (?,?,?,?,?,?,?)");
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getOffice());
			pstmt.setString(6, dto.getBirthday());
			pstmt.setString(7, dto.getSex());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
	// select where
	public DTO select(String name){
		DTO dto = null;
		String sql = "select * from custom where name=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new DTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setOffice(rs.getString("office"));
				dto.setBirthday(""+rs.getDate("birthday"));
				dto.setSex(rs.getString("sex"));
				dto.setIndate(""+rs.getDate("indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return dto;
	}
	public DTO select(int num){
		DTO dto = null;
		String sql = "select * from custom where num=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new DTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setOffice(rs.getString("office"));
				dto.setBirthday(""+rs.getDate("birthday"));
				dto.setSex(rs.getString("sex"));
				dto.setIndate(""+rs.getDate("indate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return dto;
	}
	// update
	public void update(DTO dto){
		StringBuilder sql = new StringBuilder();
		sql.append("update custom set tel=?,office=? ");
		sql.append("where name=?");
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTel());
			pstmt.setString(2, dto.getOffice());
			pstmt.setString(3, dto.getName());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
	// delete
	public void delete(DTO dto){
		StringBuilder sql = new StringBuilder();
		sql.append("delete from custom  ");
		sql.append("where num = ? and name = ?");
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
}
