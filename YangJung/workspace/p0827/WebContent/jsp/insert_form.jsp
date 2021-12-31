<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkwrite(){
	if(document.insform.userid.value==""){
		alert("아이디를 입력하세요.");
		document.insform.userid.focus();
	}
	else if(document.insform.name.value==""){
		alert("이름을 입력하세요.");
		document.insform.name.focus();
	}
	else if(document.insform.pwd.value==""){
		alert("비밀번호를 입력하세요.");
		document.insform.pwd.focus();
	}else{
		document.insform.submit();
	}
}

</script>
</head>
<body>
<form name="insform" method="post" action="insert_process.jsp">
<p>아이디 : <input type="text" name="userid" />
<p>이 름 : <input type="text" name="name" />
<p>패스워드 : <input type="password" name="pwd" />
<p><input type="button" value="저장" onclick="javascript:checkwrite()" />
</form>
</body>
</html>