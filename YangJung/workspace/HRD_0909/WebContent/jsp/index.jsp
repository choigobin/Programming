<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>레이아웃</title>
</head>
<body>
<table width="100%" height="100%" border="0" cellpading="0" celspacing="0" align="center">
<jsp:include page="header.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<tr>
	<td valign="top">
	<p align="center" style="font-weight:bold; font-size: 20px;">고등학교 성적 조회 프로그램</p>
	<p style="font-weight:bold;">고등학교 성적을 조회하는 프로그램을 작성한다.</p>
	1.학생성적정보 테이블을 생성한다.<br />
	2.학생성적정보 테이블에 샘플데이터를 SQL문을 사용하여 데이터를 추가생성한다.<br />
	3.주어진 화면디자인을 이용하여 화면을 디자인한다.<br />
	4.업무요건에 따라 프로그램을 작성한다.<br />
	</td>
</tr>
<jsp:include page="footer.jsp" flush="false" />
</table>
</body>
</html>