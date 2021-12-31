<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 ver2.0</title>
<style>
table{
	border-collapse: collapse;
}
tr,td,th{
	border: solid black 1px;
}
a{
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String uri = request.getRequestURI();
	int startIndex = uri.lastIndexOf("/");
	int endIndex = uri.lastIndexOf(".");
	String action = uri.substring(startIndex+1,endIndex);
%>
<form method="post" action="go">
<input type="hidden" value="<%=action %>" name="go">
<table width=100% height=100%>
	<tr height=100px bgcolor="skyblue">
		<td align="center">
			<span style="font-size: 30px;">생산관리 ver2.0</span>			
		</td>
	</tr>
	<tr height=50px bgcolor="gray">
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="go?go=insert">제품입력</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="go?go=search">제품조회</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="go?go=list">제품현황</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="go?go=listGroup">그룹별재고현황</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="go?go=index">홈으로</a>
		</td>
	</tr>
	<tr>