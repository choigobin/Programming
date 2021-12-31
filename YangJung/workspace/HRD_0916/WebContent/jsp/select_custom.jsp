<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Main 화면</title>
</head>
<body>
<table width=100% height=100%>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<tr>
	<td bgcolor="gray" valign="top" height="80%">
		<p align="center" style="font-size:20px">고객 정보 조회</p>
<table border="1" width="100%">
<tr>
<th>id</th>
<th>성명</th>
<th>패스워드</th>
<th>성별</th>
<th>이메일</th>
<th>휴대폰</th>
<th>전화번호</th>
<th>주소</th>
<th>차량번호</th>
<th>차량종류</th>
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
		String sql = "select * from custom_member";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			String a = rs.getString(1);
			String b = rs.getString(2);
			String c = rs.getString(3);
			String d = rs.getString(4);
			String e = rs.getString(5);
			String f = rs.getString(6);
			String g = rs.getString(7);
			String h = rs.getString(8);
			String i = rs.getString(9);
			String j = rs.getString(10);
			if(d.equals("1")){d="남";}
			if(d.equals("2")){d="여";}
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
			<td align="center"><%=j %></td>
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