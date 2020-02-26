<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert_bean.jsp" method="post">
		아이디 <input type="text" name="userid"> <br>
		이름 <input type="text" name="name"> <br>
		이메일 <input type="text" name="email"> <br>
		계절 <input type="checkbox" name="season" value="봄">봄 
			<input type="checkbox" name="season" value="여름">여름 
			<input type="checkbox" name="season" value="가을">가을
			<input type="checkbox" name="season" value="겨울">겨울
		<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>