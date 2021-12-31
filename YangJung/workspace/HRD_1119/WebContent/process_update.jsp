<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dbconn.jsp" %>
<%
String a = request.getParameter("custno");
String b = request.getParameter("custname");
String c = request.getParameter("phone");
String d = request.getParameter("address");
String e = request.getParameter("joindate");
String f = request.getParameter("grade");
String g = request.getParameter("city");

try{
String sql = "update member_tbl_02 SET custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? where custno = ?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, b);
pstmt.setString(2, c);
pstmt.setString(3, d);
pstmt.setString(4, e);
pstmt.setString(5, f);
pstmt.setString(6, g);
pstmt.setString(7, a);
pstmt.executeUpdate();
out.print("<script>history.back();alert('회원정보수정이 완료 되었습니다.');</script>");
}catch(SQLException s){
	s.getMessage();
	System.out.println("실패");
}finally{
	if(pstmt !=null) pstmt.close();
	if(conn !=null) conn.close();
}
%>