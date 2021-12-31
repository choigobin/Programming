<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>레이아웃</title>
</head>
<body>
<table width="100%" height="100%" border="1" cellpading="0" celspacing="0" align="center">
<tr>
	<td colspan="2" height="10%" bgcolor="yellow">
		<jsp:include page="header.jsp" flush="false" />
	</td>
</tr>
<tr>
	<td width="80%" valign="top">
	content 내용 
	<img src="../image/bird2.jpg" width="350" border="0" />
	</td>
	<td valign="top" width="20%">
		<jsp:include page="menu.jsp" flush="false" />
	</td>
</tr>
<tr>
	<td colspan="2" height="10%" bgcolor="gray">
	footer 내용
	</td>
</tr>
</table>
</body>
</html>