<%@ page import="java.sql.*" %>

<%
	Connection conn=null;
	
	String jdbcDriver="com.mysql.cj.jdbc.Driver";
	String jdbcurl="jdbc:mysql://localhost/yangjung?serverTimezone=UTC";
	String user="root";
	String password="1234";
		
	Class.forName(jdbcDriver);
	conn=DriverManager.getConnection(jdbcurl,user,password);
%>
