<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="dbconn.jsp" %>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	PreparedStatement pstmt=null;
	try{
		/*String sql = "insert into membertable(id, passwd, name) values(
				'"+id+"','"+passwd+"','"+name+"')";*/
		String sql="insert into membertable values(?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, name);
		pstmt.executeUpdate();
		out.println("데이터베이스 저장 성공");
	}catch(SQLException e){
		out.println("데이터베이스 저장 실패");
	}finally{
		if(pstmt !=null){
			pstmt.close();
		}
		if(conn !=null){
			conn.close();
		}
	}
%>
</body>
</html>