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
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<%
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				String sql = "select * from member";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					String id = rs.getString("userid");
					String pw = rs.getString("pwd");
					String name = rs.getString("name");
	 				%>
					<tr>
						<td><%=id%></td>
						<td><%=pw%></td>
						<td><%=name%></td>
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