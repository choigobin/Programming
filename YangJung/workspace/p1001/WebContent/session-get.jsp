<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>session 정보 가져오기</h2>
<br />
현재 세션의 아이디는 <%= session.getAttribute("id") %>입니다. <br />
현재 세셔읜 비밀번호는 <%= session.getAttribute("pwd") %>입니다. <br />
</body>
</html>