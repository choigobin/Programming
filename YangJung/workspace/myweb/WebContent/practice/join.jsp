<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html,body{margin:0; padding:0; height:100%;}
.header{
	width:100%; height:15%; background:blue;
}
.nav{
	width:100%; height:5%; background:skyblue;
}
.nav ul{margin:0; padding:0;}
.nav ul li{
	display:inline-block; disk-list:none; padding: 1px 15px;
}
.section{
	width:100%; height:80%;background:gray;
}
.footer{
	width:100%; height:10%; background:blue;
}
</style>
</head>
<body>
<header class="header">
<div align="center">
<font size=20px; color=#ffffff;>
쇼핑몰 회원관리 ver.1.0
</font>
</div>
</header>
<nav class="nav">
<ul>
<li><a href="join.jsp">회원등록</a></li>
<li><a href="#">회원목록조회/수정</a></li>
<li><a href="#">회원매출조회</a></li>
<li><a href="index.jsp">홈으로.</a></li>
</ul>
</nav>
<div align="center" class="section">
<font size="25">홈쇼핑 회원 등록</font>
<table border="1">
<tr>
	<th width="500">회원번호(자동발생)</th>
	<td width="600"><input type="text" size="20"></td>
</tr>
<tr>
	<th>회원성명</th>
	<td><input type="text" size="20"></td>
</tr>
<tr>
	<th>회원전화</th>
	<td><input type="text" size="30"></td>
</tr>
<tr>
	<th>회원주소</th>
	<td><input type="text" size="50"></td>
</tr>
<tr>
	<th>가입일자</th>
	<td><input type="text" size="20"></td>
</tr>
<tr>
	<th>고객등급[A:VIP,B:일반,C:직원]</th>
	<td><input type="text" size="20"></td>
</tr>
<tr>
	<th>도시코드</th>
	<td><input type="text" size="20"></td>
</tr>
<tr>
	<th colspan="2">
	<button type="button">등록</button>
	<button type="button">조회</button>
	</th>
</tr>
</table>
</div>
</body>
</html>