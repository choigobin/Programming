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
String passwd = request.getParameter("passwd");
String gender = request.getParameter("gender");
String email = request.getParameter("email1")+'@'+request.getParameter("email2");
String phone = request.getParameter("ph1")+'-'+request.getParameter("ph2")+'-'+request.getParameter("ph3");
String tel = request.getParameter("tel1")+'-'+request.getParameter("tel2")+'-'+request.getParameter("tel3");
String address = request.getParameter("address");
String carnumber = request.getParameter("carnumber");
String cartype = request.getParameter("cartype");

PreparedStatement pstmt = null;

try{	
	String sql = "insert into custom_member values(?,?,?,?,?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,id);
	pstmt.setString(2,name);
	pstmt.setString(3,passwd);
	pstmt.setString(4,gender);
	pstmt.setString(5,email);
	pstmt.setString(6,phone);
	pstmt.setString(7,tel);
	pstmt.setString(8,address);
	pstmt.setString(9,carnumber);
	pstmt.setString(10,cartype);
	pstmt.executeUpdate();
	out.println("<script>location.href='insert_custom.jsp'; alert('고객 정보등록이 완료 되었습니다.');</script>");
} catch(SQLException e){
	out.println("course_tbl 테이블 삽입이 실패했습니다.");
	out.println("SQLException: " + e.getMessage());
} finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>