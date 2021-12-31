<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
Connection conn = null;

String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
String user = "yangjung";
String password = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url, user, password);
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String name = request.getParameter("name");
String dept = request.getParameter("dept");
String position = request.getParameter("position");
String duty = request.getParameter("duty");
String phone = request.getParameter("phone");

PreparedStatement pstmt = null;

try{	
	String sql = "insert into personnel values(?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,id);
	pstmt.setString(2,name);
	pstmt.setString(3,dept);
	pstmt.setString(4,position);
	pstmt.setString(5,duty);
	pstmt.setString(6,phone);
	pstmt.executeUpdate();
	out.println("<script>location.href='insert01.jsp'; alert('사원등록이 완료 되었습니다.');</script>");
} catch(SQLException e){
	out.println("course_tbl 테이블 삽입이 실패했습니다.");
	out.println("SQLException: " + e.getMessage());
} finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>