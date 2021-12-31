<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 조회화면</title>
<style>
#container {
    width: 500px;
    border: 1px solid black;
    position: relative;
}
#label {
    position: absolute;
    top: -10px;
    left: 20px;
    height: 20px;
    width: 200px;
    background-color: white;
    text-align: center;
}
</style>
</head>
<body>
<form name="select" method="post" action="select02.jsp" >
	<h3>인사관리조회화면</h3>
	<div id="container">
    <div id="label">인사관리 조회</div>
    <br />
    <input type="radio" name="where" value="id">사원번호로 조회 <input type="text" name="id"/>
    <br />
    <input type="radio" name="where" value="dept">부서명으로 조회 <select name="dept">
    														<option value="인사부">인사부</option>
    														<option value="경리부">경리부</option>
    														<option value="홍보부">홍보부</option>
    														<option value="기획부">기획부</option>
    													</select>
    <br /><br />
	<input type="submit" value="조회" style="width:70pt;height:20pt;">
	<input type="button" value="취소" onclick="location.href='index.jsp'" style="width:70pt;height:20pt;">
</div>
</form>
</body>
</html>