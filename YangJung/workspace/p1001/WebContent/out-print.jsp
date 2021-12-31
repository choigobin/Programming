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
for(int i=0; i<3;i++){
	out.print("바나나");
}
%>

<%
for(int i=0; i<3;i++){
	out.println("포도");
}
%>

<%
for(int i=0; i<3;i++){
	out.print("파인애플");
	out.newLine();
}
%>
</pre>
</body>
</html>