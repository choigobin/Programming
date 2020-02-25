<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" action="Test_01">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>주민등록번호</th>
				<td>
					<input type="text" name="pass1">-
					<input type="password" name="pass2">
				</td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="job">
						<option value="학생">학생</option>
						<option value="공무원">공무원</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>관심분야</th>
				<td>
					<select multiple="multiple" name="interest">
						<option value="에스프레소">에스프레소</option>
						<option value="로스팅">로스팅</option>
						<option value="생두">생두</option>
						<option value="원두">원두</option>
						<option value="핸드드립">핸드드립</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>