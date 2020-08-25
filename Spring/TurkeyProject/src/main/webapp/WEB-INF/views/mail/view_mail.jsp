<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/turkey_style.css?ver=3" rel="stylesheet">

<title>Turkey University</title>

	<div class="post_check" onresize="parent.resizeTo(500,400)" onload="parent.resizeTo(500,400)">
		
		<c:if test="${pro_vo != null}">
		
		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<div class="post_check_adm_miniheader">
				<img src="../img/turkey_adm.png">
				<div class="post_check_adm_miniheader_name">Turkey University</div>
				<div class="post_check_adm_miniheader_description">JSL Information Portal System</div>
			</div>
		
			<div class="post_check_adm_miniheader_search_name">
				쪽지 보기
			</div>
		
			<div class="post_check_adm_miniheader_search_form">
					<div class="post_check_adm_miniheader_search_form_result">
						<form name="mail_send_form" method="post">
							<table style="margin:0 auto; text-align:center;">
								<input type="hidden" name="row1" value="${row}">
								<tr style="height:40px;">
									<td colspan="2">
										<input type="text" name="reception" value="${mailVO.sending_name}" readonly style="margin-left:30px; height:30px;">
									</td>
								</tr>
								<tr style="height:320px;">
									<td colspan="2">
										<textarea name="contents" style="font-size:15px; letter-spacing: 1.5px; margin-left:35px; width:400px; height:300px; resize:none;" readonly>${mailVO.contents}</textarea>
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
				쪽지 보기
			</div>
		
			<div class="post_check_pro_miniheader_search_form">
					<div class="post_check_adm_miniheader_search_form_result">
						<form name="mail_send_form" method="post">
							<table style="margin:0 auto; text-align:center;">
								<input type="hidden" name="row1" value="${row}">
								<tr style="height:40px;">
									<td colspan="2">
										<input type="text" name="reception" value="${mailVO.sending_name}" readonly style="margin-left:30px; height:30px;">
									</td>
								</tr>
								<tr style="height:320px;">
									<td colspan="2">
										<textarea name="contents" style="font-size:15px; letter-spacing: 1.5px; margin-left:35px; width:400px; height:300px; resize:none;" readonly>${mailVO.contents}</textarea>
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
				쪽지 보기
			</div>
		
			<div class="post_check_stu_miniheader_search_form">
				<div class="post_check_adm_miniheader_search_form_result">
						<form name="mail_send_form" method="post">
							<table style="margin:0 auto; text-align:center;">
								<input type="hidden" name="row1" value="${row}">
								<tr style="height:40px;">
									<td colspan="2">
										<input type="text" name="reception" value="${mailVO.sending_name}" readonly style="margin-left:30px; height:30px;">
									</td>
								</tr>
								<tr style="height:320px;">
									<td colspan="2">
										<textarea name="contents" style="font-size:15px; letter-spacing: 1.5px; margin-left:35px; width:400px; height:300px; resize:none;" readonly>${mailVO.contents}</textarea>
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