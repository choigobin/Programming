package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private DAO() {
	}

	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234");
		return conn;
	}

	private void clean() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(DTO dto) {
			String sql = "insert into reservation values(?,?,?,?,?,?,?)";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getLentno());
				pstmt.setString(2, dto.getCustname());
				pstmt.setInt(3, dto.getBookno());
				pstmt.setString(4, dto.getPhone());
				pstmt.setString(5, dto.getOutdate());
				if(dto.getIndate()==null||dto.getIndate().equals("null")||dto.getIndate().equals("")) {
					pstmt.setNull(6, Types.NULL);
					pstmt.setString(7, "1");
				}else {
					pstmt.setString(6, dto.getIndate());
					pstmt.setString(7, "2");
				}
				pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				clean();
			}
		

	}

	public List<DTO> select() {
		List<DTO> list = new ArrayList<DTO>();
		String sql = "select * from reservation order by lentno";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DTO dto = new DTO();
				dto.setLentno(rs.getInt("lentno"));
				dto.setBookno(rs.getInt("bookno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setOutdate(rs.getString("outdate"));
				dto.setIndate("" + rs.getDate("indate"));
				dto.setStatus(rs.getString("status"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return list;
	}

	public DTO selectNO(int x) {
		DTO dto = new DTO();
		String sql = "select * from reservation where lentno=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, x);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setLentno(rs.getInt("lentno"));
				dto.setBookno(rs.getInt("bookno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setOutdate(rs.getString("outdate"));
				dto.setIndate("" + rs.getDate("indate"));
				dto.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return dto;
	}

	public void update(DTO dto) {
		String sql = "update reservation set custname=?,bookno=?,phone=?,outdate=?,indate=?,status=? where lentno=? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustname());
			pstmt.setInt(2, dto.getBookno());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getOutdate());
			if(dto.getIndate()==null||dto.getIndate().equals("null")||dto.getIndate().equals("")) {
				pstmt.setNull(5, Types.NULL);
				pstmt.setString(6, "1");
			}else {
				pstmt.setString(5, dto.getIndate());
				pstmt.setString(6, "2");
			}
			pstmt.setInt(7, dto.getLentno());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}

	}

	public void update2(DTO dto) {
		String sql = "update reservation set indate=?, status=2 where lentno=? ";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if (dto.getIndate() == null || dto.getIndate().equals("null") || dto.getIndate().equals("")) {
				pstmt.setString(1, df.format(new Date()));
			} else {
				pstmt.setString(1, dto.getIndate());
			}
			pstmt.setInt(2, dto.getLentno());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}

}
