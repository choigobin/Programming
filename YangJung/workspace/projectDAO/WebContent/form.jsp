<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/projectDAO/add" method="get">
	<p><input type="text" name="no" placeholder="회원번호" /></p>
	<p><input type="text" name="name" placeholder="이름" /></p>
	<p><input type="text" name="email" placeholder="이메일" /></p>
	<p><input type="text" name="pwd" placeholder="비밀번호" /></p>
	
	<p><input type="submit" value="회원가입" /></p>
</form>
</body>
</html>