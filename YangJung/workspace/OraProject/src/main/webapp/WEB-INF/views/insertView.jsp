<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html>
<head>
<title>Home</title>
<title>학생정보</title>
</head>
<body>
<div id="root">
<header>
<h1> 학생정보 </h1>
</header>
<hr />
<nav>
홈 - 글 작성
</nav>
<hr />
<section id="container">
<form role="form" method="post" action="insert">
<table>
<tbody>
<tr><td><label for="no">학 번</label><input type="text" id="no" name="no" /></td></tr>
<tr><td><label for="name">이 름</label><input type="text" id="name" name="name"
/></td></tr>
<tr><td><label for="address">주 소</label><input type="text" id="address" name="address"
/></td></tr>
<tr><td><label for="hp">휴대폰</label><input type="text" id="hp" name="hp" /></td></tr>
<tr><td><label for="tel">전 화</label><input type="text" id="tel" name="tel"
/></td></tr>
<tr><td><button type="submit">저장</button></td></tr>
</tbody>
</table>
</form>
</section>
<hr />
</div>
</body>
</html>