<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${isRow==-1}">
		<script>
			alert("학번이 존재하지 않습니다.");
		</script>
	</c:when>
	<c:when test="${isRow==0}">
		<script>
			alert("비밀번호가 맞지 않습니다.");
		</script>
	</c:when>
</c:choose>
<title>Turkey University</title>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<link href="../css/turkey_style.css?ver=6" rel="stylesheet">

<div class="all">

	<div class="stu_login_top"></div>

	<div class="stu_login">

		<div class="stu_login_logo">
			<img src="/img/big_stu.png">
		</div>

		<div class="stu_login_form">
			<form name="login" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/Turkey/pro_login">교수님이신가요? ➞</a>
				<input type="text" name="stu_code" placeholder="학생학번"> 
				<input type="password" name="stu_pw" placeholder="비밀번호">
				<br>
				<input type="button" class="btn_stu_log" value="로그인" onclick="send()">
				<input type="button" value="학번찾기" class="btn_stu_find" onclick="find_code()">
				<input type="button" value="비밀번호변경" class="btn_stu_find" onclick="find_pass()">
			</form>
		</div>
		
	</div>

	<div class="stu_login_bottom"></div>
</div>


<script>
   function send(){
      if(login.stu_code.value==""){
    	  alert("학번을 입력하세요");
    	  login.stu_code.focus();
    	  return;
      }
      if(login.stu_pw.value==""){
    	  alert("비밀번호를 입력하세요");
    	  login.stu_pw.focus();
    	  return;
      }
	login.action="stu_login";
    login.submit();
   }
   
   function find_code() {
	   window.open("stu_find_code", "stu_find_code_form", "height=540,width=510,left=560,top=230");
   }
   
   function find_pass() {
	   window.open("stu_find_pass", "stu_find_pass_form", "height=540,width=510,left=560,top=230");
   }
</script>