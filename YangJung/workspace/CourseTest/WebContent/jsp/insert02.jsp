<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lecturer_tbl 삽입</title>
</head>
<body>
<form method="post" action="insert_process02.jsp">
<table border = "1">
	<tr>
		<th>번호</th> <th>강사명</th> <th>전공</th> <th>세부전공</th>
	</tr>
	<tr>
		<td><input type="text" name="idx"></td>
		<td><input type="text" name="name"></td>
		<td><input type="text" name="major"></td>
		<td><input type="text" name="field"></td>
	</tr>
	<tr>
		<td colspan ="4" align="center"><input type="submit" value="저장" /></td>
	</tr>
</table>	
</form>
</body>
</html>