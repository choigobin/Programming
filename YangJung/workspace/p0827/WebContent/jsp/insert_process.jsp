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
<%
Connection conn = null;

String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
String user = "yangjung";
String password = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url, user, password);
request.setCharacterEncoding("utf-8");

String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");

PreparedStatement pstmt = null;

try{	
	String sql = "insert into member(userid, pwd, name) values(?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userid);
	pstmt.setString(2, pwd);
	pstmt.setString(3, name);
	pstmt.executeUpdate();
	out.println("Member 테이블 삽입이 성공했습니다");
	//response.sendRedirect("insert_form.jsp");
} catch(SQLException e){
	out.println("Member 테이블 삽입이 실패했습니다.");
	out.println("SQLException: " + e.getMessage());
} finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>
</body>
</html>