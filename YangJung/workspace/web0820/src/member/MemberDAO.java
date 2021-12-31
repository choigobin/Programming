package member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "1234";
	String driver ="oracle.jdbc.driver.OracleDriver";
	
	//member 목록 읽기
	public List<MemberVO> ListMembers(){
		List<MemberVO> list = new ArrayList<>();
		
		try {
			connDB();  //DB연결 하는 메소드
			String sql = "select * from t_member";
			rs = stmt.executeQuery(sql); //sql문으로 회원 정보 조회
			
			while(rs.next()) {
				String id=rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally { //무조건 리소스 해제
			try {
				if (rs !=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (stmt !=null) stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn !=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	// DB 접속
	private void connDB() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
