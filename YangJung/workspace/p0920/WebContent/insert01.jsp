<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 사원등록화면</title>
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
<form name="insert" method="post" action="insert02.jsp" >
	<h3>인사관리 사원등록화면</h3>
	<div id="container">
    <div id="label">인사관리 사원등록</div>
    <br />
    <table>
    <tr>
    <td>성 명</td><td>:<input type="text" name="name"/></td>
    </tr>
    <tr>
    <td>사원번호</td><td>:<input type="text" name="id"/></td>
    </tr>
    <tr>
    <td>소속부서</td><td>:<select name="dept">
    					<option value="인사부">인사부</option>
    					<option value="경리부">경리부</option>
    					<option value="홍보부">홍보부</option>
    					<option value="기획부">기획부</option>
    					</select>
    				</td>
    </tr>
    <tr>
    <td>직 급</td><td>:<select name="position">
    					<option value="1">1급</option>
    					<option value="2">2급</option>
    					<option value="3">3급</option>
    					<option value="4">4급</option>
    					</select>
    			</td>
    </tr>
    <tr>
    <td>직 책</td><td>:<input type="text" name="duty"/></td>
    </tr>
    <tr>
    <td>연락처</td><td>:<input type="text" name="phone"/></td>
    </tr>
    <tr>
    <td colspan="2">
    <input type="submit" value="등록" style="width:70pt;height:20pt;">
	<input type="button" value="취소" onclick="location.href='index.jsp'" style="width:70pt;height:20pt;">
    </td>
    </tr>
	</table>
</div>
</form>
</body>
</html>