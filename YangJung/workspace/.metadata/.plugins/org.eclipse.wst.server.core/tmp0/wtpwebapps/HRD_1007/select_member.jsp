<%@page import="com.sun.prism.Presentable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid black;
	border-collapse: collapse;
	}
tr, td{
	border: 1px solid black;
	}
a{ color: white; text-decoration: none;}

</style>
</head>
<body>
<table height="100%" width="100%">
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<tr>
<td bgcolor="gray" valign="top">
<table width="100%" align="center">
<tr >
<th>id</th><th>성명</th><th>패스워드</th><th>성별</th><th>생년월일</th><th>이메일</th><th>휴대폰</th><th>주소</th><th>닉네임</th>
</tr>
<%
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
	String sql = "select * from web_member";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		String a = rs.getString(1);
		String b = rs.getString(3);
		String c = rs.getString(2);
		String d = rs.getString(4);
		String e = rs.getString(5);
		String f = rs.getString(6);
		String g = rs.getString(7);
		String h = rs.getString(8);
		String i = rs.getString(9);
		%>
		<tr>
		<td align="center"><%=a %></td>
		<td align="center"><%=b %></td>
		<td align="center"><%=c %></td>
		<td align="center"><%=d %></td>
		<td align="center"><%=e %></td>
		<td align="center"><%=f %></td>
		<td align="center"><%=g %></td>
		<td align="center"><%=h %></td>
		<td align="center"><%=i %></td>
		</tr>
		<%
	}
			
}catch (SQLException e){
	out.println("테이블 호출 실패"+e.getMessage());
}finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(conn!=null) conn.close();
}
%>
</table>
</td>
</tr>
<jsp:include page="footer.jsp"/>
</table>
</body>
</html>