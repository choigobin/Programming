<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String passwd = request.getParameter("password");
String gender = request.getParameter("gender");
String birth = request.getParameter("birth");
String email = request.getParameter("email1")+request.getParameter("email2");
String phone = request.getParameter("tel1")+'-'+request.getParameter("tel2")+'-'+request.getParameter("tel3");
String address = request.getParameter("address");
String nick = request.getParameter("nick");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String user = "yangjung";
String password = "1234";
String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url, user, password);
request.setCharacterEncoding("utf-8");
try{
	String sql = "select id from web_member where id="+id;
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		if(rs.getString(1).equals(id)){%>
			<script>alert('이미 등록된 아이디 입니다.'); window.history.back(); </script>
			<%
		}
	}
			
}catch (SQLException e){
	out.println("테이블 호출 실패"+e.getMessage());
}finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(conn!=null) conn.close();
}

conn = null;
pstmt= null;

conn = DriverManager.getConnection(url, user, password);

try{	
	String sql = "insert into web_member values(?,?,?,?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,id);
	pstmt.setString(2,passwd);
	pstmt.setString(3,name);
	pstmt.setString(4,gender);
	pstmt.setString(5,birth);
	pstmt.setString(6,email);
	pstmt.setString(7,phone);
	pstmt.setString(8,address);
	pstmt.setString(9,nick);
	pstmt.executeUpdate();
	out.println("<script>location.href='insert_member.jsp'; alert('고객 정보등록이 완료 되었습니다.');</script>");
} catch(SQLException e){
	out.println("테이블 삽입이 실패했습니다.");
	out.println("SQLException: " + e.getMessage());
} finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>