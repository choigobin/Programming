<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=forward_action2.jsp method=post>
	forward action : <input type="text" name="username" />
	<input type="submit" value="확인" />
</form>
<form action=response_sendRedirect.jsp method=post>
	response.sendRedirect : <input type="text" name="username" />
	<input type="submit" value="확인" />
</form>
</body>
</html>