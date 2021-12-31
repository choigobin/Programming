<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> enums = request.getParameterNames();
	while(enums.hasMoreElements()){
		String name=(String)enums.nextElement();
		out.print(name + ": ");
		String value = request.getParameter(name);
		out.print(value +"<br>");
	}
%>

</body>
</html>