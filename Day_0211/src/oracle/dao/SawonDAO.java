package oracle.dao;

import java.sql.*;
import java.util.*;

import oracle.db.DBManager;
import oracle.dto.DeptVO;
import oracle.dto.EmpVO;

public class SawonDAO {
	DBManager manager = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 부서 정보 테이블 전체 검색 메소드 정의
	public List<DeptVO> deptList() {
		String query = "select * from dept";
		// 리턴타입 정의
		List<DeptVO> list = new ArrayList<DeptVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDno(rs.getInt("dno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 부서,직급으로 검색 AND
	public EmpVO searchEmp(String dno, String job) {
		EmpVO vo = null;
		String sql = "select * from emp where dno = "+dno+" and job = '"+job+"'";
		try {
			Connection conn = manager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEno(rs.getInt("ENO"));
				vo.setEname(rs.getString("ENAME"));
				vo.setJob(rs.getString("JOB"));
				vo.setManager(rs.getInt("MANAGER"));
				vo.setHiredate(rs.getString("HIREDATE"));
				vo.setSalary(rs.getInt("SALARY"));
				vo.setCommission(rs.getInt("COMMISSION"));
				vo.setDno(rs.getInt("DNO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return vo;
	}
	// 부서 또는 직급으로 검색 OR
	public List<EmpVO> searchEmpO(String dno, String job){
		List<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "select * from emp where dno = "+dno+" or job = '"+job+"'";
		try {
			Connection conn = manager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo = new EmpVO();
				vo.setEno(rs.getInt("ENO"));
				vo.setEname(rs.getString("ENAME"));
				vo.setJob(rs.getString("JOB"));
				vo.setManager(rs.getInt("MANAGER"));
				vo.setHiredate(rs.getString("HIREDATE"));
				vo.setSalary(rs.getInt("SALARY"));
				vo.setCommission(rs.getInt("COMMISSION"));
				vo.setDno(rs.getInt("DNO"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
	
}
