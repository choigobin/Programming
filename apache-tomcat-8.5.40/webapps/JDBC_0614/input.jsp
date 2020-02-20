<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="upload.do" enctype="multipart/form-data">
	작성자 : <input type="text" name="name"><br>
	제목 : <input type="text" name="subject"><br>
	첨부파일 : <input type="file" name="upfile"><br>
	<input type="submit" value="전송"><br>
	
</form>
</body>
</html>