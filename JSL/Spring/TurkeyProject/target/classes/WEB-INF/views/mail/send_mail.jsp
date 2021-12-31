<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/turkey_style.css?ver=5" rel="stylesheet">

<c:if test="${row==0}">
	<script>
		alert("없는 수신인 입니다.\n 다시 체크 해주세요");
	</script>
</c:if>
<c:if test="${row==1}">
	<script>
		alert("수신인 체크가 되었습니다.");
	</script>
</c:if>

<title>Turkey University</title>

	<div class="post_check" onresize="parent.resizeTo(550,400)" onload="parent.resizeTo(550,400)">
		
		<c:if test="${pro_vo != null}">
		
		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<div class="post_check_adm_miniheader">
				<img src="../img/turkey_adm.png">
				<div class="post_check_adm_miniheader_name">Turkey University</div>
				<div class="post_check_adm_miniheader_description">JSL Information Portal System</div>
			</div>
		
			<div class="post_check_adm_miniheader_search_name">
				쪽지 보내기
			</div>
		
			<div class="post_check_adm_miniheader_search_form">
					<div class="post_check_adm_miniheader_search_form_result">
						<form name="mail_send_form" method="post">
							<table style="margin:0 auto; text-align:center;">
								<input type="hidden" name="row1" value="${row}">
								<tr style="height:40px;">
									<td>
										<input type="text" name="reception" placeholder="받는사람" value="${reception}" style="margin-left:-80px; height:30px;">
									</td>
									<td>
										<input type="button" value="조회" onclick="re_check()" style="margin-left:-220px; width:90px;">
									</td>
								</tr>
								<tr style="height:320px;">
									<td colspan="2">
										<textarea name="contents" style="margin-left:35px; width:400px; height:300px; resize:none;"></textarea>
									</td>
								</tr>
								<tr style="height:40px; width:400px;">
									<td>
										<input type="button" value="보내기" onclick="send()"style="margin-left:-140px; width:90px;">
									</td>
									<td>
										<a href="javascript:history.back()"><input type="button" value="취소" style="margin-left:-220px; width:90px;"></a>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<a href="/Turkey/list_send_mail">  <input type="button" value="보낸쪽지" style="width:100px;"></a>
					<a href="/Turkey/list_mail"><input type="button" value="받은쪽지" style="width:100px;"></a>
					<a href="/Turkey/send_mail"><input type="button" value="쪽지전송" style="width:100px;"></a>
			</div>
		</c:if>
		
		<!-- 교수 -->
		<c:if test="${pro_vo.pro_code != '00000'}">
			<div class="post_check_pro_miniheader">
				<img src="../img/turkey_pro.png">
				<div class="post_check_pro_miniheader_name">Turkey University</div>
				<div class="post_check_pro_miniheader_description">JSL Information Portal System</div>
			</div>
		
		<div class="post_check_pro_miniheader_search_name">
				쪽지 보내기
			</div>
		
			<div class="post_check_pro_miniheader_search_form">
					<div class="post_check_adm_miniheader_search_form_result">
						<form name="mail_send_form" method="post">
							<table style="margin:0 auto; text-align:center;">
								<input type="hidden" name="row1" value="${row}">
								<tr style="height:40px;">
									<td>
										<input type="text" name="reception" placeholder="받는사람" value="${reception}" style="margin-left:-80px; height:30px;">
									</td>
									<td>
										<input type="button" value="조회" onclick="re_check()" style="margin-left:-220px; width:90px;">
									</td>
								</tr>
								<tr style="height:320px;">
									<td colspan="2">
										<textarea name="contents" style="margin-left:35px; width:400px; height:300px; resize:none;"></textarea>
									</td>
								</tr>
								<tr style="height:40px; width:400px;">
									<td>
										<input type="button" value="보내기" onclick="send()"style="margin-left:-140px; width:90px;">
									</td>
									<td>
										<a href="javascript:history.back()"><input type="button" value="취소" style="margin-left:-220px; width:90px;"></a>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<a href="/Turkey/list_send_mail">  <input type="button" value="보낸쪽지" style="width:100px;"></a>
					<a href="/Turkey/list_mail"><input type="button" value="받은쪽지" style="width:100px;"></a>
					<a href="/Turkey/send_mail"><input type="button" value="쪽지전송" style="width:100px;"></a>
			</div>
		</c:if>
		
	</c:if>
	
	<!-- 학생 -->
	<c:if test="${stu_vo != null}">
		<div class="post_check_stu_miniheader">
			<img src="../img/turkey_stu.png">
			<div class="post_check_stu_miniheader_name">Turkey University</div>
			<div class="post_check_stu_miniheader_description">JSL Information Portal System</div>
		</div>
		
		<div class="post_check_stu_miniheader_search_name">
				쪽지 보내기
			</div>
		
			<div class="post_check_stu_miniheader_search_form">
				<div class="post_check_adm_miniheader_search_form_result">
						<form name="mail_send_form" method="post">
							<table style="margin:0 auto; text-align:center;">
								<input type="hidden" name="row1" value="${row}">
								<tr style="height:40px;">
									<td>
										<input type="text" name="reception" placeholder="받는사람" value="${reception}" style="margin-left:-80px; height:30px;">
									</td>
									<td>
										<input type="button" value="조회" onclick="re_check()" style="margin-left:-220px; width:90px;">
									</td>
								</tr>
								<tr style="height:320px;">
									<td colspan="2">
										<textarea name="contents" style="margin-left:35px; width:400px; height:300px; resize:none;"></textarea>
									</td>
								</tr>
								<tr style="height:40px; width:400px;">
									<td>
										<input type="button" value="보내기" onclick="send()"style="margin-left:-140px; width:90px;">
									</td>
									<td>
										<a href="javascript:history.back()"><input type="button" value="취소" style="margin-left:-220px; width:90px;"></a>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<a href="/Turkey/list_send_mail">  <input type="button" value="보낸쪽지" style="width:100px;"></a>
					<a href="/Turkey/list_mail"><input type="button" value="받은쪽지" style="width:100px;"></a>
					<a href="/Turkey/send_mail"><input type="button" value="쪽지전송" style="width:100px;"></a>
			</div>
	</c:if>
</div>
	
<script>
	function re_check(){
		if(mail_send_form.reception.value==""){
			alert("수신인 학번을 입력 하세요");
			mail_send_form.reception.focus();
			return;
		}
		mail_send_form.action="/Turkey/re_check";
		mail_send_form.submit();
	}
	function send(){
		if(mail_send_form.reception.value==""){
			alert("수신인 학번을 입력 하세요");
			mail_send_form.reception.focus();
			return;
		}
		if(mail_send_form.contents.value==""){
			alert("내용을 입력하세요");
			mail_send_form.contents.focus();
			return;
		}
		if(mail_send_form.row1.value=="0"){
			alert("수신인 체크를 하세요");
			return;
		}
		mail_send_form.action="/Turkey/send_mail";
		mail_send_form.submit();
	}
	
</script>