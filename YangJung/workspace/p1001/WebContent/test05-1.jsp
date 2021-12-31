<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	double temp = Double.parseDouble(request.getParameter("temp"));
	double result = (temp*9/5)+32;
%>
<h1>사용자 정의 함수 사용 예제</h1>

섭씨 <%=temp %>도는 화씨 <%=result %>도 입니다.
</body>
</html>