<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${isRow==-1}">
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
			비밀번호 찾기
			<img src="../img/search_stu.png">
		</div>
		<c:if test="${isRow == null || isRow == -1}">
			<div class="post_check_stu_miniheader_search_form">
				<form name="find_pass" method="post" action="stu_find_pass">
					<input type="text" name="stu_code" placeholder="학번" maxlength="8"><br><br>
					<input type="text" name="stu_name" placeholder="이름"><br><br>
					<input type="text" name="stu_birth" placeholder="생년월일 (8자)" maxlength="8"><br><br>
					<input type="button" value="확인" onclick="check()"><br><br>
				</form>
			</div>
		</c:if>
		<c:if test="${isRow == 0 }">
			<div class="post_check_stu_miniheader_search_form">
				<form name="up_pass" method="post" action="stu_up_pass?stu_code=${vo.stu_code }">
					<div class="find_code_check">
						<b>${vo.stu_name }</b>님의 비밀번호를 변경하여 주십시오.<br><br>
						<input type="password" name="stu_pw" placeholder="비밀번호"><br><br>
						<input type="password" name="stu_pw_r" placeholder="비밀번호 확인"><br><br>
						<input type="button" value="변경" onclick="up_p()"><br><br>
					</div>
				</form>
			</div>
		</c:if>
		<c:if test="${isRow == 1 }">
			<div class="post_check_stu_miniheader_search_form">
				<form name="up_pass" method="post" action="stu_up_pass">
					<div class="find_code_check"> 비밀번호가 정상적으로 변경 되었습니다.<br><br>
						<input type="button" value="닫기" onclick="clo_p()">
					</div>
				</form>
			</div>
		</c:if>
	</div>

	<script>
		function check() {
			if(find_pass.stu_code.value == ""){
				alert("학번을 입력하여 주세요.");
				find_pass.stu_code.focus();
				return;
			}
			
			if(find_pass.stu_name.value == ""){
				alert("이름을 입력하여 주세요.");
				find_pass.stu_name.focus();
				return;
			}
			
			if(find_pass.stu_birth.value == ""){
				alert("생년월일 8자를 입력하여 주세요.");
				find_pass.stu_birth.focus();
				return;
			}
			
			if(find_pass.stu_birth.value.length != 8){
				alert("생년월일 8자를 입력하여 주세요.");
				find_pass.stu_birth.focus();
				return;
			}
			
			find_pass.submit();
		}
		
		function win_close() {
			opener.login.stu_code.value = '${vo.stu_code}';
			self.close();
		}
		
		function up_p() {
			if(up_pass.stu_pw.value == ""){
				alert("비밀번호를 입력하여 주세요.");
				up_pass.stu_pw.focus();
				return;
			}
			
			if(up_pass.stu_pw_r.value == ""){
				alert("비밀번호를 확인하여 주세요.");
				up_pass.stu_pw_r.focus();
				return;
			}
			
			if(up_pass.stu_pw.value != up_pass.stu_pw_r.value){
				alert("비밀번호가 맞지 않습니다.");
				up_pass.stu_pw_r.focus();
				return;
			}
			
			up_pass.submit();
		}
		
		function clo_p(){
			self.close();
		}
	</script>