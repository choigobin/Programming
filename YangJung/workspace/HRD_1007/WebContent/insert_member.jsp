<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	if(document.insert.id.value==""){
		alert("아이디를 입력하세요.");
		document.insert.id.focus();
	}
	else if(document.insert.name.value==""){
		alert("이름을 입력하세요.");
		document.insert.name.focus();
	}
	else if(document.insert.password.value==""){
		alert("비밀번호를 입력하세요.");
		document.insert.passwd.focus();
	}
	else{
		document.insert.submit();
	}
}
</script>
<style>
table{
	border: 1px solid black;
	border-collapse: collapse;
	}
tr, td{
	border: 1px solid black;
	}
a{ color: white; text-decoration: none;}

</style>
</head>
<body>
<table height="100%" width="100%">
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<tr>
<td bgcolor="gray" valign="top">
<h2 align="center">회원 정보 등록 화면</h2>
<form action="insertA01.jsp" name="insert" method="get">
<table width="80%" align="center">
<tr>
<td align="center" width=100px;>아이디</td>
<td><input type="text" name="id" /></td>
</tr>
<tr>
<td align="center">이름</td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td align="center">비밀번호</td>
<td><input type="text" name="password" /></td>
</tr>
<tr>
<td align="center">성별</td>
<td><input type="radio" name="gender" value="남성"/>남<input type="radio" name="gender" value="여성"/>여</td>
</tr>
<tr>
<td align="center">생년월일</td>
<td><input type="text" name="birth"/></td>
</tr>
<tr>
<td align="center">이메일</td>
<td><input type="text" name="email1" />@<select name="email2">
<option value="@naver.com">naver.com</option>
<option value="@nate.com">nate.com</option>
</select>
</td>
</tr>
<tr>
<td align="center">핸드폰</td>
<td>
<select name="tel1">
<option value="010">010</option><option value="011">011</option><option value="016">016</option>
</select>-<input type="text" name="tel2" size=7;/>-<input type="text" name="tel3" size=7; />
</td>
</tr>
<tr>
<td align="center">주소</td>
<td><input type="text" name="address" size=50;/></td>
</tr>
<tr>
<td align="center">닉네임</td>
<td><input type="text" name="nick"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="button" onclick="javascript:check()" value="회원등록" /><input type="reset" value="다시작성" />
</td>
</tr>
</table>
</form>
</td>
</tr>
<jsp:include page="footer.jsp"/>
</table>
</body>
</html>