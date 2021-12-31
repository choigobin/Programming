<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script>
	function loginCheck(){
		if (document.frm.userid.value.length == 0){
			alert("아이디를 입력해주세요")
			return false;
		}
		if (document.frm.pwd.value == ""){
			alert("암호를 입력해주세요.")
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<%
String message = (String)request.getAttribute("message");
if (message == null ){
	message = "";
}

%>
<h2>로그인:<%=request.getContextPath() %></h2>
<hr />
<form action="<%=request.getContextPath() %>/login.do" method="post" name="frm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value=""></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan = "2">
			<input type="submit" value="로그인" onclick="return loginCheck()"/>&nbsp;&nbsp;
			<input type="reset" value="취소"/>&nbsp;&nbsp;
			<input type="button" value="회원가입" onclick="location.href='join.do'"/>
			</td>
		</tr>
	</table>
</form>
<hr>
<%=message %>
</body>
</html>