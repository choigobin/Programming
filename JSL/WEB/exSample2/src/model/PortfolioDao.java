package model;

import java.sql.*;
import java.util.*;

public class PortfolioDao {
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
		 String sql = "select no from PP_Portfolio order by no desc";
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
	 
	 public int insertPortfolio(PortfolioVO vo) {
		 int result = 0;
		 int no = selectMaxNo()+1;
		 String sql = "insert into PP_Portfolio(no,title,contents) values(?,?,?)";
		 try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cleanUp();
		}
		 return result;
	 }
	 
	 public int updatePortfolio(PortfolioVO vo) {
			int result = 0;
			String sql = "update PP_Portfolio set title=?, contents=? where no = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContents());
				pstmt.setInt(3, vo.getNo());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return result;
		}
		
		public int deletePortfolio(int no) {
			int result = 0;
			String sql = "delete from PP_Portfolio where no = ?";
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
		
		public void readPortfolio(int no) {
			String sql = " update PP_Portfolio set readcnt = readcnt+1 where no = ?";
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
		
		public int countPortfolio() {
			int result = 0;
			String sql = "select count(*) from PP_Portfolio";
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
		
		public List<PortfolioVO> selectPortfolio(int pg){
			List<PortfolioVO> list = new ArrayList<PortfolioVO>();
			String sql = "select * from (select x.*,  ROW_NUMBER() OVER (order by no desc) n from PP_Portfolio x) where n between ? and ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pg*10-9);
				pstmt.setInt(2, pg*10);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					PortfolioVO vo = new PortfolioVO();
					vo.setNo(rs.getInt("no"));
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setInsertdate(""+rs.getDate("insertdate"));
					vo.setTitle(rs.getString("title"));
					vo.setContents(rs.getString("contents"));
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return list;
		}
		
		public PortfolioVO viewPortfolio(int no) {
			PortfolioVO vo = new PortfolioVO();
			String sql = "select * from PP_Portfolio where no = ?";
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
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cleanUp();
			}
			return vo;
		}
	
	 
}
