<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
post.html에서 넘어온 데이터 <br /><br />
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String id = request.getParameter("id");
String dept = request.getParameter("dept");
%>
이름 : <%=name %> <br />
학번 : <%=id %> <br />
소속 : <%=dept %> <br />
</body>
</html>