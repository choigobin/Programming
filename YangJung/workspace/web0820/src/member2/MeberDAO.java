package member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import config.DB;

public class MeberDAO {
	//사용자 인증시 사용되는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select userid, pwd from member where userid=?";
		
		Connection conn = null; //db 연결하는 객체
		PreparedStatement pstmt = null; //sql문장 처리하는 객체
		ResultSet rs = null; //db처리 결과값 반환
		
		try {
			conn = DB.dbCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); // sql 수행결과
			
			if (rs.next()) {
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					result = 1; //정삭적으로 인정
				}else {
					result = 0; // 비밀번호 불일치
				}
			} else {
				result = -1; //-1은 자료가 없음 = 비회원
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs !=null) rs.close();
				if (pstmt !=null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}
		
	//아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String userid) {
		//DB 필드값을 객체에 보관하는 객체
		MemberVO vo = null;
		
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs !=null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn !=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		return vo;
	}
}
