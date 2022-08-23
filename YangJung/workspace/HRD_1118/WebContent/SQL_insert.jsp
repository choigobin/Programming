<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
Connection conn = null;
PreparedStatement pstmt = null;
request.setCharacterEncoding("utf-8");
Class.forName("oracle.jdbc.OracleDriver");
conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/testdb", "scott", "1234");

String custno = request.getParameter("custno");
String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String joindate = request.getParameter("joindate");
String grade = request.getParameter("grade");
String city = request.getParameter("city");

try{
	String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, custno);
	pstmt.setString(2, custname);
	pstmt.setString(3, phone);
	pstmt.setString(4, address);
	pstmt.setString(5, joindate);
	pstmt.setString(6, grade);
	pstmt.setString(7, city);
	pstmt.executeUpdate();
	out.println("<script>location.href='insert.jsp'; alert('고객 정보등록이 완료 되었습니다.');</script>");
}catch(SQLException e){
	System.out.print(e.getMessage());
	out.print("<script>location.href='insert.jsp';alert('입력실패');</script>");
}finally{
	if(pstmt!=null) pstmt.close();
	if(conn!=null) conn.close();
}
%>