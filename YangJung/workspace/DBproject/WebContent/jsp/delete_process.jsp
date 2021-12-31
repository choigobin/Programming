<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
		<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		try{
			String sql="select id, passwd from membertable where id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String rId=rs.getString(1);
				String rPasswd=rs.getString(2);
				if(passwd.equals(rPasswd)){
					sql = "delete from membertable where id=? and passwd=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1,id);
					pstmt.setString(2,passwd);
					pstmt.executeUpdate();
					out.println("삭제 완료");
				}else{
					out.println("비밀번호가 일치하지 않음");}
			}else{
				out.println("일치하는 아이디가 없음");}
			
		}catch(SQLException e){
			out.println("데이터베이스 삭제 에러");
		}finally{
			if(rs !=null){
				rs.close();}
			if(pstmt !=null){
				pstmt.close();}
			if(conn !=null){	
				conn.close();}
		}
		%>
</body>
</html>