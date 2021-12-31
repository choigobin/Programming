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
int grade = Integer.parseInt(request.getParameter("grade"));
String point = "";

if(grade>=80){
	point = "당신의 성적은 A 입니다.";
}
else if(grade>=60){
	point = "당신의 성적은 B입니다.";
}
else if(grade>=40){
	point = "당신의 성적은 C입니다.";
}
else{
	point = "당신의 성적은 F입니다.";
}
%>
<h1><%=point %></h1>
</body>
</html>