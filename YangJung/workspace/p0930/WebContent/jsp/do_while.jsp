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
	int i = 0;
	int sum= 0;
	do{
		i++;
		sum+=i;
		if(sum>=10000){
			break;
		}
	}while(i<=1000);
%>
<%=i %><br />
<%=sum %>
</body>
</html>