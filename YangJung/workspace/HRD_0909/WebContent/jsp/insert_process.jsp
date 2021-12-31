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
<%
Connection conn = null;

String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
String user = "yangjung";
String password = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url, user, password);
request.setCharacterEncoding("utf-8");

String sno = request.getParameter("sno");
String sname = request.getParameter("sname");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");
String hist = request.getParameter("hist");

PreparedStatement pstmt = null;

try{	
	String sql = "insert into examtbl values(?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,sno);
	pstmt.setString(2,sname);
	pstmt.setString(3,kor);
	pstmt.setString(4,eng);
	pstmt.setString(5,math);
	pstmt.setString(6,hist);
	pstmt.executeUpdate();
	out.println("<script>location.href='insert01.jsp'; alert('성적입력이 완료 되었습니다.');</script>");
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