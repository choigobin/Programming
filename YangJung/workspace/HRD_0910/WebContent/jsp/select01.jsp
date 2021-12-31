<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>main화면</title>
</head>
<body>
<table width=100% height=100% border="0" cellpading="0" celspacing="0" align="center">
<jsp:include page="header.jsp" flush="false"/>
<jsp:include page="nav.jsp" flush="false"/>
<tr>
	<td bgcolor="gray" valign="top" height="80%">
		<p align="center" style="font-size:20px">직원 정보 조회</p>
<table border="1" width="100%">
<tr>
<th>no</th>
<th>성명</th>
<th>사번</th>
<th>직급</th>
<th>직책</th>
<th>연락처</th>
<th>소속부서</th>
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
	int no = 0;
	try{
		String sql = "select name,id,position,duty,phone,dept from personnel order by id";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			String a = rs.getString(1);
			String b = rs.getString(2);
			String c = rs.getString(3);
			String d = rs.getString(4);
			String e = rs.getString(5);
			String f = rs.getString(6);
			no +=1;
			%>
			<tr>
			<td align="center"><%=no %></td>
			<td align="center"><%=a %></td>
			<td align="center"><%=b %></td>
			<td align="center"><%=c %></td>
			<td align="center"><%=d %></td>
			<td align="center"><%=e %></td>
			<td align="center"><%=f %></td>
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
<jsp:include page="footer.jsp" flush="false"/>
</table>
</body>
</html>