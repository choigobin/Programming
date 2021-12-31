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
	text-align: center;
	}
</style>
</head>
<body>
<table>
<tr>
	<td>대출번호</td>
	<td>대출자</td>
	<td>도서명</td>
	<td>대출일</td>
	<td>반납일</td>
	<td>대출상태</td>
</tr>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String user = "yangjung";
	String password ="1234";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	request.setCharacterEncoding("utf-8");
	
	try{
		String sql = "select * from reservation_tbl";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			String a = rs.getString(1);
			String b = rs.getString(2);
			String c = rs.getString(3);
			String d = rs.getString(4);
			String e = rs.getString(5);
			String f = rs.getString(6);
			%>
			<tr>
				<td><%=a %></td>
				<td><%=b %></td>
				<td><%=c %></td>
				<td><%=d %></td>
				<td><%=e %></td>
				<td><%=f %></td>
			</tr>
			<%
		}
		
	}catch(Exception e){
		out.println(e.getMessage());
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
	}
%>
</table>
</body>
</html>