<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jdbc 연결 테스트</title>
</head>
<body>
<h2>jdbc 연결하기</h2>
<hr>
<%
Connection conn=null;
Statement stmt=null;
ResultSet rs = null;

// String url = "jdbc:oracle:thin:@localhost:1521:xe"; oracle 11XE
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String user = "scott";
String password = "1234";

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Oracle 드라이버 로딩 성공..");
	
	conn = DriverManager.getConnection(url, user, password);
	System.out.println("Connection 생성 성공");
	
	stmt = conn.createStatement();
	System.out.println("Statement 생성 성공");
	
	String sql = "select * from t_member";
	rs = stmt.executeQuery(sql);
	
	while(rs.next()){
		out.println(rs.getString("id"));
		out.println(rs.getString("pwd"));
		out.println(rs.getString("name"));
		out.println(rs.getString("email"));
		out.println(rs.getDate("joinDate"));
		out.print("<hr>");
		
	}
	
}catch(Exception e){
	e.printStackTrace();
}

%>

</body>
</html>