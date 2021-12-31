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
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
%>
<div align="center">
<h1>덧셈과 뺄셈</h1> <br />
<h1>x: <%=x %> y: <%=y %></h1> <br />
<%=x %> + <%=y %> = <%=x+y %> <br />
<%=x %> - <%=y %> = <%=x-y %>

</div>
</body>
</html>