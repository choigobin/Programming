<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="research_01.jsp" method=post name="frm">
	<table border="1">
		<tr>
			<td> 이름 : </td>
			<td><input type="text" name="name" size=20></td>
		</tr>
		<tr>
			<td> 성별 : </td>
			<td>
				<input type="radio" name="gender" value="male" checked> 남자
				<input type="radio" name="gender" value="female"> 여자
			</td>
		</tr>
		<tr>
			<td> 좋아하는 계절 : </td>
			<td>
				<input type="checkbox" name="season" value="봄" >봄
				<input type="checkbox" name="season" value="여름" checked> 여름
				<input type="checkbox" name="season" value="가을" > 가을
				<input type="checkbox" name="season" value="겨울" > 겨울
			</td>
		</tr>
		<tr align=center>
			<td colspan="2"><input type="submit" value="전송1">
			<input type="reset" value="취소"></td>
		</tr>
		<tr align=center>
			<td colspan="2">
				<input type="button" value="전송2" onclick="frm.action='research_02.jsp';frm.submit()">
				<input type="reset" value="취소">
			</td>
		</tr>
		<tr align=center>
			<td colspan="2">
				<input type="button" value="전송3" onclick="frm.action='research_03.jsp';frm.submit()">
				<input type="reset" value="취소">
			</td>
		</tr>
		<tr align=center>
			<td colspan="2">
				<input type="button" value="전송4" onclick="frm.action='research_04.jsp';frm.submit()">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>