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
	int score;
	score = 75;
	String temp;
	
	if(score >= 90)
		temp = "pass";
	else
		temp = "fail";
%>
<%=temp %>

<%
	int today = 3;
	String day;
	
	switch(today){
		case 1:
			day="Monday"; break;
		case 2:
			day="Tuesday"; break;
		case 3:
			day="Wendnesday"; break;
		case 4:
			day="Thursday"; break;
		case 5:
			day="Friday"; break;
		case 6:
			day="Saturday"; break;
		default:
			day="Sunday"; break;
	}
%>
Today is <%= day %>!
</body>
</html>