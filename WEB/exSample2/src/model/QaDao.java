package model;

import java.sql.*;
import java.util.*;

public class QaDao {
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
	 
	 private int selectMaxNo() {
		 int max = 0;
		 String sql = "select no from PP_Qa order by no desc";
		 try {
				conn = getConnection();
				pstmt=conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					max=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
		 return max;
	 } 
	 
	 public int insertQa(QaVO vo) {
		 int result = 0;
		 int no = selectMaxNo()+1;
		 String sql = "insert into PP_Qa(no,userid,title,contents) values(?,?,?,?)";
		 try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cleanUp();
		}
		 return result;
	 }
	 
	 public int replyQa(QaVO vo) {
			int result = 0;
			String sql = "update PP_Qa set reply=? where no = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getReply());
				pstmt.setInt(2, vo.getNo());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return result;
		}
		
		public int deleteQa(int no) {
			int result = 0;
			String sql = "delete from PP_Qa where no = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return result;
		}
		
		public void readQa(int no) {
			String sql = " update PP_Qa set readcnt = readcnt+1 where no = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
		}
		
		public int countQa() {
			int result = 0;
			String sql = "select count(*) from PP_Qa";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return result;
		}
		
		public List<QaVO> selectQa(int pg){
			List<QaVO> list = new ArrayList<QaVO>();
			String sql = "select * from (select x.*,  ROW_NUMBER() OVER (order by no desc) n from PP_Qa x) where n between ? and ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pg*10-9);
				pstmt.setInt(2, pg*10);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					QaVO vo = new QaVO();
					vo.setNo(rs.getInt("no"));
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setInsertdate(""+rs.getDate("insertdate"));
					vo.setTitle(rs.getString("title"));
					vo.setContents(rs.getString("contents"));
					vo.setUserid(rs.getString("userid"));
					vo.setReply(rs.getString("reply"));
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return list;
		}
		
		public QaVO viewQa(int no) {
			QaVO vo = new QaVO();
			String sql = "select * from PP_Qa where no = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					vo.setNo(rs.getInt("no"));
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setInsertdate(""+rs.getDate("insertdate"));
					vo.setTitle(rs.getString("title"));
					vo.setContents(rs.getString("contents"));
					vo.setUserid(rs.getString("userid"));
					vo.setReply(rs.getString("reply"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return vo;
		}
	
	 
}
