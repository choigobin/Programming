<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ch06 : page_control_end.jsp</title>
</head>
<body>
<div align="center">
<h2>forward action 및 sendRiedirect() 결과</h2>
<hr />
지금 보이는 화면은 page_control_end.jsp 에서 출력한 결과 입니다.
<hr />
이름 : <%= request.getParameter("username") %> <br />
전화번호 : <%= request.getParameter("tel") %>
</div>
</body>
</html>