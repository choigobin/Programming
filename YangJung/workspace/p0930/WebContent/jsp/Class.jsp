<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String str1="milk1";
	String str2="MILK2";

%>
<%="대문자 변환 : "+str1.toUpperCase() %> <br />
<%="소문자 변환 : "+str1.toLowerCase() %> <br /> <br />

<%
	Date d = new Date();
%>
<%=d.getYear()+1900 %>년
<%=d.getMonth()+1 %>월
<%=d.getDate() %>일 <br /><br />

</body>
</html>