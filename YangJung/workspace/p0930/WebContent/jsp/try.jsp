<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		int a =0;
		int num = 100/a;
		
		out.println(num);
	}catch(Exception e){
		out.println("오류가 발생했습니다." + e.getMessage()+"<br>");
	}finally{
		out.println("무조건 실행되는 부분입니다.");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>