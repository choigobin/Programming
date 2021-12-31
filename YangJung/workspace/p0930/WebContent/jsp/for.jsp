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
	int i, fac=1;
	for (i=1;i<=10;i++){
		fac = fac*i;
	}	
%>
10!=<%=fac %> <br /><br />
<%
	int sum=0;
	for(i=1;i<=100;i++){
		sum= sum+i;
	}
%>
1에서 100까지의 합 <%=sum %> <br />
<%
	int odd=0,even =0;
	for(i=1;i<=100;i++){
		if(i%2==0){
			even=even+i;
		}
		else{
			odd=odd+i;
		}
	}
%>
1에서 100까지의 홀수 합 <%=odd %> <br />
1에서 100까지의 짝수 합 <%=even %> <br />
</body>
</html>