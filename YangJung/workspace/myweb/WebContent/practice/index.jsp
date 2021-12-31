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
	width:100%; height:70%; background:gray;
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
<section class="section">
<div align="center">
<font size="15">쇼핑몰 회원관리 프로그램</font>
</div>
<div align="left">
쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
프로그램 작성 순서<br>
1.회원정보 테이블을 생선한다.<br>
2.매출정보 테이블을 생선한다.<br>
3.회원정보,매출정보테이블에 제시된 문제지의 참조데이터를 추가 생선한다.<br>
4.회원정보 입력 화면프로그램을 작성한다.<br>
5.회원정보 조회 프로그램을 작성한다.<br>
6.회원매출정보 조회 프로그램을 작성한다.<br>
</div>
</section>
<footer class="footer">
<div align="center">
<font color=#ffffff;>
HRDKOREA Copyrightⓒ2016  All rights reserved. Human Resources Development Service of Korea
</font>
</div>
</footer>
</body>
</html>