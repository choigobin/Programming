package model;

import java.sql.*;
import java.util.*;

import db.DBManager;

public class DataDAO {
	DBManager manager = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//메소드 정의
	public List<EmpVO> exam_01(){
		String sql = "select ename,salary,salary+300 as temp from emp";
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				vo.setTemp(""+rs.getInt("temp"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_02(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,salary,salary*12+100 as temp from emp ");
		sql.append("order by temp desc");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				vo.setTemp(""+rs.getInt("temp"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_03(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,salary from emp ");
		sql.append("where salary>2000");
		sql.append("order by salary desc");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_04(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,dno from emp ");
		sql.append("where eno=7788");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setDno(rs.getInt("dno"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_05(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,salary from emp ");
		sql.append("where salary not between 2000 and 3000");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_06(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,job,hiredate from emp ");
		sql.append("where hiredate between '81/02/20' and '81/05/01'");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setHiredate(""+rs.getDate("hiredate"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_07(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,dno from emp ");
		sql.append("where dno in(20,30) ");
		sql.append("order by ename");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setDno(rs.getInt("dno"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	public List<EmpVO> exam_08(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,salary,dno from emp ");
		sql.append("where salary between 2000 and 3000 and dno in(20,30) ");
		sql.append("order by ename");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDno(rs.getInt("dno"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_09(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,hiredate from emp ");
		sql.append("where hiredate like '81%' ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setHiredate(""+rs.getDate("hiredate"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_10(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,job from emp ");
		sql.append("where manager is null ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_11(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,salary,commission from emp ");
		sql.append("where commission is not null ");
		sql.append("order by salary, commission ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				vo.setCommission(rs.getInt("commission"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_12(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename from emp ");
		sql.append("where ename like '__R%' ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_13(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename from emp ");
		sql.append("where ename like '%A%' and ename like '%E%' ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_14(){
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,job,salary from emp ");
		sql.append("where job in('CLERK','SALESMAN')  ");
		sql.append("and salary not in (1600,950,1300) ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_15(){
		
		StringBuilder sql = new StringBuilder();
		sql.append("select ename,salary,commission from emp ");
		sql.append("where commission >=500  ");
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("salary"));
				vo.setCommission(rs.getInt("commission"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
}
