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
String id = request.getParameter("id");
String name = request.getParameter("name");
String credit = request.getParameter("credit");
String lecturer = request.getParameter("lecturer");
String week = request.getParameter("week");
String start_hour = request.getParameter("start_hour");
String end_end = request.getParameter("end_end");

PreparedStatement pstmt = null;

try{	
	String sql = "insert into course_tbl values(?,?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,id);
	pstmt.setString(2,name);
	pstmt.setString(3,credit);
	pstmt.setString(4,lecturer);
	pstmt.setString(5,week);
	pstmt.setString(6,start_hour);
	pstmt.setString(7,end_end);
	pstmt.executeUpdate();
	out.println("course_tbl 테이블 삽입이 성공했습니다");
	//response.sendRedirect("insert_form.jsp");
} catch(SQLException e){
	out.println("course_tbl 테이블 삽입이 실패했습니다.");
	out.println("SQLException: " + e.getMessage());
} finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>
</body>
</html>