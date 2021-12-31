package model;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	private static Connection getConnection() throws Exception {
		Connection conn;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		return conn;
	}
	private void cleanUp() {
		try {
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원 정보 등록 메소드
	public boolean memberInsert(MemberVO vo) {
		String sql = "insert into tbl_member(idx,name,userid,passwd,tel) values(TBLMEMBER_SEQ_IDX.nextval,?,?,?,?)";
		boolean flag = false;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getTel());
			pstmt.execute();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cleanUp();
		}
		return flag;
	}
	// id 중복 검사 메소드
	public boolean memberIDcheck(String userid) {
		String sql = "select * from tbl_member where userid = ?";
		boolean flag = false;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cleanUp();
		}
		return flag;
	}
	// 회원 전체 목록 검색 메소드
	public List<MemberVO> memberSelect(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql="select * from tbl_member";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setGubun(rs.getString("gubun"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));
				vo.setJob(rs.getString("job"));
				vo.setIntro(rs.getString("intro"));
				vo.setFavorite(rs.getString("favorite"));
				vo.setFirst_time(rs.getString("first_time"));
				vo.setLast_time(rs.getString("last_time"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cleanUp();
		}
		
		return list;
	}
	// 우편번호 검색 메소드
		public List<ZipcodeVO> zipcodeSelect(String addr){
			List<ZipcodeVO>  list = new ArrayList<ZipcodeVO>();
			String sql="select * from zipcode where dong like '%"+addr+"%'";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ZipcodeVO vo = new ZipcodeVO();
					vo.setZipcode(rs.getString("zipcode"));
					vo.setSido(rs.getString("sido"));
					vo.setGugun(rs.getString("gugun"));
					vo.setDong(rs.getString("dong"));
					vo.setBunji(rs.getString("bunji"));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cleanUp();
			}
			
			return list;
		}
	
	// 로그인 검사(id, passs 체크) 메소드
		public int memberLogin(String userid,String passwd) {
			int row=-1;
			String pwCheck="";
			String sql = "select passwd from tbl_member where userid = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					pwCheck=rs.getString("passwd");
					if(pwCheck.equals(passwd)) {
						// 로그인 성공
						sql="update tbl_member set last_time = sysdate where userid = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, userid);
						pstmt.execute();
						row=1;
					}else {
						// 비번오류
						row=0;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				cleanUp();
			}
			return row;
		}
	// id 또는 기본키에 해당하는 회원 정보 검색 메소드
	
	// 회원정보 수정 메소드
}
