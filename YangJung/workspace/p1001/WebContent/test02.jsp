<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form action="test02-1.jsp">
아이디 : <input type="text" name="id" /> <br />
비밀번호 : <input type="text" name="pwd"/> <br />
이 름 : <input type="text" name="name"/> <br />
연락처 : <input type="text" name="tel1"/>-
<input type="text" name="tel2" />-
<input type="text" name="tel3" /> <br />
성 별 : <input type="radio" name="gender" value="남성"/>남성
 <input type="radio" name="gender" value="여성"/>여성 <br />
취 미 : 독서<input type="checkbox" name="hobby" value="독서" /> 
운동<input type="checkbox" name="hobby" value="운동" /> 
영화<input type="checkbox" name="hobby" value="영화" /> <br />
직 업 : <select name="job">
		<option value="무직">무직</option>
		<option value="회사원">회사원</option>
		<option value="전문직">전문직</option>
		<option value="학생">학생</option>
		</select> <br />
<input type="submit" value="전송" /> <input type="reset" value="다시쓰기" />
</form>
</body>
</html>