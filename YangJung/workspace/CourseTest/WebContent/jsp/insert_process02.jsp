<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="dbconn.jsp" %>
<%
String idx = request.getParameter("idx");
String name = request.getParameter("name");
String major = request.getParameter("major");
String field = request.getParameter("field");

PreparedStatement pstmt = null;

try{	
	String sql = "insert into lecturer_tbl values(?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,idx);
	pstmt.setString(2,name);
	pstmt.setString(3,major);
	pstmt.setString(4,field);
	pstmt.executeUpdate();
	out.println("lecturer_tbl 테이블 삽입이 성공했습니다");
	//response.sendRedirect("insert_form.jsp");
} catch(SQLException e){
	out.println("lecturer_tbl 테이블 삽입이 실패했습니다.");
	out.println("SQLException: " + e.getMessage());
} finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>
</body>
</html>