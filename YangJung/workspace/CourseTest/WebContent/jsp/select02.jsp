<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청 도우미 사이트</title>
</head>
<body>
<table width ="100%" height = "100%" border="2">
<tr>
	<td colspan = "2" bgcolor="yellow" height = "10%">
		<jsp:include page="header.jsp" flush="false" />
	</td>
</tr>
<tr>
	<td valign = "top" width="80%">
	<jsp:include page="select_process02.jsp" flush="false"/>
	</td>
	<td valign = "top" width="20%">
	<jsp:include page="right.jsp" flush="false" />
	</td>
</tr>
<tr>
	<td colspan = "2" bgcolor="gray" height = "7%">
		<jsp:include page="footer.jsp" flush="false"/>
	</td>
</tr>
</table>

</body>
</html>