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
	<form method="post" action="insert_process01.jsp">
<p align="center"><span style="font-weight:bold; font-size:1.2em">
교과목 명세
</span></p>
<table border = "1" align="center" width="90%">
<tr>
	<td width="90" align="center">교과목 코드</td>
	<td><input type="text" size="50" name="id"></td>
</tr>
<tr>
	<td align="center">과목명</td>
	<td><input type="text" size="50" name="name"></td>
</tr>
<tr>
	<td align="center">담당강사</td>
	<td><input type="text" size="40" name="lecturer"></td>
</tr>
<tr>
	<td align="center">학점</td>
	<td><input type="text" size="40" name="credit"></td>
</tr>
<tr>
	<td align="center">요일</td>
	<td>
	<input type="radio" name="week" value="1">월
	<input type="radio" name="week" value="2">화
	<input type="radio" name="week" value="3">수
	<input type="radio" name="week" value="4">목
	<input type="radio" name="week" value="5">금
	<input type="radio" name="week" value="6">토
	</td>
</tr>
<tr>
	<td align="center">시작</td>
	<td><input type="text" size="40" name="start_hour"></td>
</tr>
<tr>
	<td align="center">종료</td>
	<td><input type="text" size="40" name="end_end"></td>
</tr>
<tr align="center">
	<td colspan="2">
	<input type="button" value="목록" />&nbsp
	<input type="submit" value="저장" />
	</td>
</tr>
</table>	
</form>
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