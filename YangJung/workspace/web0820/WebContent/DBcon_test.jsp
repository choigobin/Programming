<%@page import="config.DB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결 테스트</title>
</head>
<body>
<% 
Connection conn = DB.dbCon();
System.out.print("Connection 성공..");
%>
</body>
</html>
