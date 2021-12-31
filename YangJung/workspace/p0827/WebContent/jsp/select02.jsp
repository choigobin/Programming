<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "yangjung";
		String password = "1234";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
		request.setCharacterEncoding("utf-8");
	%>
	<table width="300" border="1">
		<tr>
			<th>EMPNO</th>
			<th>EMPNAME</th>
			<th>TITLE</th>
			<th>MANAGER</th>
			<th>SALARY</th>
			<th>DNO</th>
		</tr>
		<%
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				String sql = "select * from employee";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					String a = rs.getString("empno");
					String b = rs.getString("empname");
					String c = rs.getString("title");
					String d = rs.getString("manager");
					String e = rs.getString("salary");
					String f = rs.getString("dno");
	 				%>
					<tr>
						<td><%=a%></td>
						<td><%=b%></td>
						<td><%=c%></td>
						<td><%=d%></td>
						<td><%=e%></td>
						<td><%=f%></td>
					</tr>
					<%
					}
				} catch (SQLException e) {
					out.println("Member 테이블 호출이 실패했습니다.<br>");
					out.println("SQLException: " + e.getMessage());
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				}
		%>
	</table>
</body>
</html>