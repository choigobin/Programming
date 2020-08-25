<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<link href="../css/turkey_style.css?ver=7" rel="stylesheet">

<div class="all">

	<div class="stu_login_top"></div>

	<div class="pro_login">

		<div class="stu_login_logo">
			<img src="/img/big_pro.png">
		</div>

		<div class="pro_login_form">
			<form name="login" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/Turkey/stu_login">학생이신가요? ➞</a>
				<input type="text" name="pro_code" placeholder="교수학번"> 
				<input type="password" name="pro_pw" placeholder="비밀번호">
				<br>
				<input type="button" class="btn_pro_log" value="로그인" onclick="send()">
			</form>
		</div>
		
	</div>

	<div class="stu_login_bottom"></div>
</div>


<script>
   function send(){
      if(login.pro_code.value==""){
    	  alert("학번을 입력하세요");
    	  login.pro_code.focus();
    	  return;
      }
      if(login.pro_pw.value==""){
    	  alert("비밀번호를 입력하세요");
    	  login.pro_pw.focus();
    	  return;
      }
      
      login.action="pro_login";
      
      login.submit();
   }
</script>