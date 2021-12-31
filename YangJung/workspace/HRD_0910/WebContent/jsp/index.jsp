<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>main화면</title>
</head>
<body>
<table width=100% height=100% border="0" cellpading="0" celspacing="0" align="center">
<jsp:include page="header.jsp" flush="false"/>
<jsp:include page="nav.jsp" flush="false"/>
<tr>
	<td bgcolor="gray" valign="top" height="80%">
		<p align="center" style="font-size:20px">인사관리 시스템</p>
		<p style="fontsize:15px">&nbsp&nbsp인사관리 시스템을 작성한다.</p>
		1. 인사관리 데이터베이스를 구축한다.<br>
		2. 인사관리 테이블에 샘플데이터를 SQL문을 사용하여 데이터를 추가한다.<br>
		3. 주어진 화면디자인을 이용하여 화면을 디자인한다.<br>
		4. 업무요건에 따라 프로그램을 작성한다.<br>
	</td>
</tr>
<jsp:include page="footer.jsp" flush="false"/>
</table>
</body>
</html>