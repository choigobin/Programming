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
	String[] jewel = new String[4];
	jewel[0] = "pearl";
	jewel[1] = "crystal";
	jewel[2] = "jade";
	jewel[3] = "sapphire";
%>
[ 배열 jewel[4]의 내용] <br>
<%=jewel[0] %>
<%=jewel[1] %>
<%=jewel[2] %>
<%=jewel[3] %>
</body>
</html>