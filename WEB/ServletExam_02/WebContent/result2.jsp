<%@page import="java.net.URLDecoder"%>
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
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	name= URLDecoder.decode(name, "utf-8");
%>
이름 : <%=name %><br>
성별 : <%=request.getParameter("gender") %><br>
계절 : <%=URLDecoder.decode(request.getParameter("season"), "utf-8") %><br>
</body>
</html>