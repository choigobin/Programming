package oracle.exam;

import java.sql.*;

import oracle.db.OracleConn;

public class OracleSQL extends OracleConn {
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 전체 검색
	public void deptLsitPrint() throws Exception {
		String query = "select * from dept";
		stmt = myConn.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			int dno = rs.getInt("dno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.println(dno + "\t" + dname + "\t" + loc);
		}
	}

	// 부서번호 검색 부서
	public void deptSearchDno(int dno) throws Exception {
		String query = "select * from dept where dno = ?";
		pstmt = myConn.prepareStatement(query);
		pstmt.setInt(1, dno);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("dno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.println(no + "\t" + dname + "\t" + loc);
		}
	}

	// 부서번호 검색 사원
	public void empSearchDno(int dno) throws Exception {
		String query = "select * from emp where dno = ?";
		pstmt = myConn.prepareStatement(query);
		pstmt.setInt(1, dno);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			if (rs.getString(3).length() > 7) {
				System.out.print(rs.getString(3) + "\t");
			} else {
				System.out.print(rs.getString(3) + "\t\t");
			}
			System.out.print(rs.getInt(4) + "\t");
			System.out.print(rs.getString(5) + "\t");
			System.out.print(rs.getInt(6) + "\t");
			System.out.print(rs.getInt(7) + "\t");
			System.out.print(rs.getInt(8) + "\n");
		}
	}

	// 날짜 검색
	public void empSearchDate(String date) throws Exception {
		String query = "select * from emp where hiredate >= ?";
		pstmt = myConn.prepareStatement(query);
		pstmt.setString(1, date);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			if (rs.getString(3).length() > 7) {
				System.out.print(rs.getString(3) + "\t");
			} else {
				System.out.print(rs.getString(3) + "\t\t");
			}
			System.out.print(rs.getInt(4) + "\t");
			System.out.print(rs.getString(5) + "\t");
			System.out.print(rs.getInt(6) + "\t");
			System.out.print(rs.getInt(7) + "\t");
			System.out.print(rs.getInt(8) + "\n");
		}
	}
	// 이름 검색
	public void nameSearch(String name) throws Exception{
		String query="select eno, ename, job, hiredate from "
				+ "emp where ename like ?";
		pstmt = myConn.prepareStatement(query);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			if(rs.getString(3).length()>7) {
				System.out.print(rs.getString(3) + "\t");
			}else {
				System.out.print(rs.getString(3) + "\t\t");
			}
			System.out.print(rs.getString(4).substring(0,10) + "\n");
			
		}
		
	}
	
	public void cleanUp() throws Exception {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
	}

}
