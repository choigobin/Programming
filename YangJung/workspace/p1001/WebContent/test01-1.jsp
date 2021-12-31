<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
<%

int dan = Integer.parseInt(request.getParameter("dan"));

for(int i=0;i <= 9; i++){
	out.println(dan+" * "+i+" = "+i*dan);
	System.out.println(dan+" * "+i+" = "+i*dan);
}

%>
</pre>
</body>
</html>