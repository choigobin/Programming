<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${isRow==0}">
		<script>
			alert("학번이 존재하지 않습니다.");
		</script>
	</c:when>
</c:choose>

<link href="../css/turkey_style.css?ver=6" rel="stylesheet">

<title>Turkey University</title>

	<div class="post_check" onresize="parent.resizeTo(500,400)" onload="parent.resizeTo(500,400)">
		<div class="post_check_stu_miniheader">
			<img src="../img/turkey_stu.png">
			<div class="post_check_stu_miniheader_name">Turkey University</div>
			<div class="post_check_stu_miniheader_description">JSL Information Portal System</div>
		</div>
		<div class="post_check_stu_miniheader_search_name">
			학번 찾기
			<img src="../img/search_stu.png">
		</div>
		<c:if test="${isRow == null || isRow == 0}">
			<div class="post_check_stu_miniheader_search_form">
				<form name="find_code" method="post" action="stu_find_code">
					<input type="text" name="stu_name" placeholder="이름"><br><br>
					<input type="text" name="stu_birth" placeholder="생년월일 (8자)" maxlength="8"><br><br>
					<input type="text" name="stu_email" placeholder="이메일"><br><br>
					<input type="button" value="조회" onclick="check()"><br><br>
				</form>
			</div>
		</c:if>
		<c:if test="${isRow == 1 }">
			<div class="post_check_stu_miniheader_search_form">
				<form>
					<div class="find_code_check">
						<b>${vo.stu_name }</b>님의 학번은 [<b> <a href="#" onClick="win_close()">${vo.stu_code}</a> </b>] 입니다.
					</div>
				</form>
			</div>
		</c:if>
	</div>

	<script>
		function check() {
			if(find_code.stu_name.value == ""){
				alert("이름을 입력하여 주세요.");
				find_code.stu_name.focus();
				return;
			}
			
			if(find_code.stu_birth.value == ""){
				alert("생년월일 8자를 입력하여 주세요.");
				find_code.stu_birth.focus();
				return;
			}
			
			if(find_code.stu_birth.value.length != 8){
				alert("생년월일 8자를 입력하여 주세요.");
				find_code.stu_birth.focus();
				return;
			}
			
			if(find_code.stu_email.value == ""){
				alert("이메일을 입력하여 주세요.");
				find_code.stu_email.focus();
				return;
			}
			
			find_code.submit();
		}
		
		function win_close() {
			opener.login.stu_code.value = '${vo.stu_code}';
			self.close();
		}
	</script>