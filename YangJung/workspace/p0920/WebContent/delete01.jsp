<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 퇴사처리 화면</title>
<style>
#container {
    height: 200px;
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
<form name="delete" method="post" action="delete02.jsp" >
	<h3>인사관리 퇴사처리 화면</h3>
	<div id="container">
    <div id="label">인사관리 사원정보 변경</div>
    <br />
    <table>
    <tr>
    <td>성 명</td><td>:<input type="text" name="name"/></td>
    </tr>
    <tr>
    <td>사원번호</td><td>:<input type="text" name="id"/></td>
    </tr>
    <tr>
    <td colspan="2">
    <input type="submit" value="삭제" style="width:70pt;height:20pt;">
	<input type="button" value="취소" onclick="location.href='index.jsp'" style="width:70pt;height:20pt;">
    </td>
    </tr>
	</table>
</div>
</form>
</body>
</html>