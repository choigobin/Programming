<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 시스템</title>
<style>
#container {
    width: 300px;
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
	<h3>인사관리시스템</h3>
	<div id="container">
    <div id="label">인사관리 메인메뉴</div>
    <br />
    <table>
    <tr>
    <td>
    <input type="button" value="조회" onclick="location.href='select01.jsp'" style="width:70pt;height:30pt;">
    </td>
    <td>
    <input type="button" value="사원등록" onclick="location.href='insert01.jsp'" style="width:70pt;height:30pt;">
    </td>
    <td>
    <input type="button" value="정보변경" onclick="location.href='update01.jsp'" style="width:70pt;height:30pt;">
    </td>
    </tr>
    <tr>
    <td>
    <input type="button" value="퇴사처리" onclick="location.href='delete01.jsp'" style="width:70pt;height:30pt;">
    </td>
    <td>
    <input type="button" value="퇴사처리" onclick="location.href='delete01.jsp'" style="width:70pt;height:30pt;">
    </td>
    <td></td>
    </tr>
    </table>
</div>
</body>
</html>