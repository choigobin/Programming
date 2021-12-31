<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>session 정보 설정</h2>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>

	아이디는 <%= id %> 입니다. <br />
	비밀번호는 <%= pw %> 입니다. <br />
<%
	session.setAttribute("id", id);
	session.setAttribute("pwd", pw);
%>

	<a href="session-get.jsp">session-get 페이지로 이동</a>
</body>
</html>