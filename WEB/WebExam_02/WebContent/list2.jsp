<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%@ 
	JSP 문서임을 알려주는 부분
	import 작성 부분
%>
--------------------------------
<!%
	선언부
	전역변수 선언, 메소드 정의
%>
--------------------------------
<%
	스크립트릿
	지역변수 선언, JAVA 문법(코딩)
%>
--------------------------------
<%= 출력부 %>
--------------------------------
--%>
<%
	//JSP 내장객체 : request(요청), response(응답), out, application, context, page
	String age = request.getParameter("age");//전송의 기본은 문자열
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과<br>
이름 : <%=name %><br>
나이 : <%=age %><br>
성별 : <%=gender %><br>
</body>
</html>