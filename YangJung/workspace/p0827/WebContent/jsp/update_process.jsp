<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update_process</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;		
		
		try{
			String sql = "select userid, pwd from member where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				String rId = rs.getString("userid");
				String rPwd = rs.getString("pwd");
				
				if(id.equals(rId) && pwd.equals(rPwd)){
					sql = "update member set name = ? where userid = ?";
					pstmt.close();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
					out.println("Member 테이블을 수정했습니다");
				}else
					out.println("일치하는 비밀번호가 아닙니다");
			}else
				out.println("Member 테이블에 일치하는 아이디가 없습니다");
			
		} catch (SQLException e){
			out.println("SQLException : "+ e.getMessage());
		} finally{
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	%>
</body>
</html>