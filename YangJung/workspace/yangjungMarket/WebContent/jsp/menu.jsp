<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String sessionId = (String) session.getAttribute("sessionId");
%>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="welcome.jsp">Home</a>
				<a class="navbar-brand" href="products.jsp">상품목록</a>
			</div>
			<div>
				<ul class="navbar-nav-mr-auto">
					
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>