<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>제품코드 조회 결과</h1>
<hr />
<table border="1">
<tr>
<td align="center" colspan="2">제조사 조회 결과</td>
</tr>
<%
 String user = "yangjung";
 String password = "1234";
 String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
 String id = request.getParameter("id");
 Date time = new Date();
 String name = "";
 
 Connection conn = null;
 PreparedStatement pstmt = null;
 ResultSet rs = null;
 
 Class.forName("oracle.jdbc.driver.OracleDriver");
 conn = DriverManager.getConnection(url, user, password);
 request.setCharacterEncoding("utf-8");
 try{
	 String sql = "select name from SWL5 where id= ?";
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1, id);
	 rs = pstmt.executeQuery();
	 rs.next();
	 name = rs.getString(1);
 }catch(Exception e){
	name = "등록되지 않은 제품 입니다!!!";
 }finally{
	 if(rs!=null) rs.close();
	 if(pstmt!=null) pstmt.close();
	 if(conn!=null) conn.close();
 }
%>
<tr>
	<td>제품코드</td>
	<td><%=id %></td>
</tr>
<tr>
	<td>제조사명</td>
	<td><%=name %></td>
</tr>
<tr>
	<td>조회일시</td>
	<td><%=time %></td>
</tr>
</table>
</body>
</html>