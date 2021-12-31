package sawon.model;

import java.sql.*;
import java.util.*;

public class DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<DTO> list = null;
	private DAO() {}
	private static DAO instance = new DAO();
	public static DAO getInstance() {
		return instance;
	}
	private static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw ="1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	private void clean() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// select e.*, dname
	public List<DTO> select(){
		list = new ArrayList<DTO>();
		String sql = "select e.*, dname from employee e, department d where e.dno = d.dno";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setEno(rs.getInt("eno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setManager(rs.getInt("manager"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission(rs.getInt("commission"));
				dto.setDname(rs.getString("dname"));
				dto.setDno(rs.getInt("dno"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return list;
	}
	//select dept
	public List<DTO> selectDept(){
		list = new ArrayList<DTO>();
		String sql = "select * from department";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setDname(rs.getString("dname"));
				dto.setDno(rs.getInt("dno"));
				dto.setLoc(rs.getString("loc"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return list;
	}
	// insert into employee
	public void insert(DTO dto) {
		String sql = "insert into employee values(emp_seq_eno.nextval,?,?,?,?,?,?,?)";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getJob());
			pstmt.setInt(3, dto.getManager());
			pstmt.setString(4, dto.getHiredate());
			pstmt.setInt(5, dto.getSalary());
			pstmt.setInt(6, dto.getCommission());
			pstmt.setInt(7, dto.getDno());
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
	public DTO select(DTO dto) {
		String sql = "select a.job,b.ename,a.hiredate,a.salary,a.commission,c.dname from employee a " 
					+ "join employee b on a.manager = b.eno(+) join department c on a.dno = c.dno " 
					+ "where a.eno =? and a.ename =?";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getEno());
			pstmt.setString(2, dto.getEname());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setJob(rs.getString("job"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(""+rs.getDate("hiredate"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission(rs.getInt("commission"));
				dto.setDname(rs.getString("dname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return dto;
	}
	public DTO select(int eno) {
		DTO dto = new DTO();
		String sql = "select * from employee where eno = ?";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setEno(rs.getInt("eno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setManager(rs.getInt("manager"));
				dto.setHiredate(""+rs.getDate("hiredate"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission(rs.getInt("commission"));
				dto.setDno(rs.getInt("dno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
		return dto;
	}
	//update
	public void update(DTO dto) {
		String sql = "update employee set ename=?,job=?,manager=?,hiredate=?,salary=?,commission=?,dno=? where eno = ?";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getJob());
			pstmt.setInt(3, dto.getManager());
			pstmt.setString(4, dto.getHiredate());
			pstmt.setInt(5, dto.getSalary());
			pstmt.setInt(6, dto.getCommission());
			pstmt.setInt(7, dto.getDno());
			pstmt.setInt(8, dto.getEno());
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
	//delete
	public void delete(DTO dto) {
		String sql = "delete from employee where eno = ?";
		try {
			conn = DAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getEno());
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clean();
		}
	}
}
