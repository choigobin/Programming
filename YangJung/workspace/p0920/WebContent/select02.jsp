<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회결과</title>
<style type="text/css">
table
{
border:1px solid black;
border-collapse:separate;
}
td, th
{
border:1px solid black;
}
</style>
</head>
<body>
  <h3>직원 정보 조회 결과</h3>
  <hr />
  <table>
  	<tr>
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
	
	String where = request.getParameter("where");
	String id = request.getParameter("id");
	String dept = request.getParameter("dept");
	String x = "";
	if(where.equals("id")){
		x=id;
	}
	else{
		x=dept;
	} 
	try{
		String sql = "select name, id, position, duty, phone, dept from personnel where "+where+"='"+x+"'";
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
  <input type="button" value="확인" onclick="location.href='select01.jsp'" style="width:70pt;height:20pt;">
</body>
</html>