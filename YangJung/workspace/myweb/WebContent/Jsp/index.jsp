<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html,body{margin:0; padding:0; height:100%}
.header{width:100%;height: 15%;
	background:yellow;}
.nav{width:100%;height: 10%; float: left;
	background:skyblue;}
#menubar{
	background:skyblue;
}
#menubar ul{
	margin:0; padding:0;
	width: 567px;
}
#menubar ul li{
	display:inline-block;
	list-style-type:none;
	padding:15px 15px;
}

.section{width:80%;height: 60%; float: left;
	background:olive;}
.aside{width:20%;height: 60%; float:left;
	background:orange;}
.footer{width:100%;height: 15%;clear:both;
	background:plum;}	
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<%@ include file="section.jsp" %>
<%@ include file="aside.jsp" %>
<%@ include file="footer.jsp" %>

</body>
</html>