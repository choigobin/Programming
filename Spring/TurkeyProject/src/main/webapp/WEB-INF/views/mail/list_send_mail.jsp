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
				보낸 쪽지함
			</div>
		
			<div class="post_check_adm_miniheader_search_form">
				
				<form>
					<div class="post_check_adm_miniheader_search_form_result">
						<table style="text-align:center;">
						<colgroup>
							<col width="100px">
							<col width="300px">
							<col width="100px">
						</colgroup>
						<tr>
								<th style="border-right:0.5px solid #000; font-size:14px;">보낸사람</th>
								<th style="border-right:0.5px solid #000; font-size:14px;">내용</th>
								<th style="font-size:14px;">날짜</th>
							</tr>
						<colgroup>
							<col width="100px">
							<col width="300px">
							<col width="100px">
						</colgroup>
						<c:forEach var="sendmail" items="${send_mail_list}">
							<tr>
								<th style="border-right:0.5px solid #000; font-size:14px;">${sendmail.sending}</th>
								<th style="border-right:0.5px solid #000; font-size:14px;">${sendmail.contents}</th>
								<th style="font-size:14px;">${sendmail.regdate.substring(0,10)}</th>
							</tr>
						</c:forEach>
					</table>
					</div>
				</form>
				<a href="/Turkey/list_send_mail">  <input type="button" value="보낸쪽지" style="width:100px;margin-top:50px;"></a>
				<a href="/Turkey/list_mail"><input type="button" value="받은쪽지" style="width:100px;margin-top:50px;"></a>
				<a href="/Turkey/send_mail"><input type="button" value="쪽지전송" style="width:100px;margin-top:50px;"></a><br><br>
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
				보낸 쪽지함
			</div>
		
			<div class="post_check_pro_miniheader_search_form">
				
				<form>
					<div class="post_check_adm_miniheader_search_form_result">
						<table style="text-align:center;">
						<colgroup>
							<col width="100px">
							<col width="300px">
							<col width="100px">
						</colgroup>
						<tr>
								<th style="border-right:0.5px solid #000; font-size:14px;">보낸사람</th>
								<th style="border-right:0.5px solid #000; font-size:14px;">내용</th>
								<th style="font-size:14px;">날짜</th>
							</tr>
						<colgroup>
							<col width="100px">
							<col width="300px">
							<col width="100px">
						</colgroup>
						<c:forEach var="sendmail" items="${send_mail_list}">
							<tr>
								<th style="border-right:0.5px solid #000; font-size:14px;">${sendmail.sending}</th>
								<th style="border-right:0.5px solid #000; font-size:14px;">${sendmail.contents}</th>
								<th style="font-size:14px;">${sendmail.regdate.substring(0,10)}</th>
							</tr>
						</c:forEach>
					</table>
					</div>
				</form>
				<a href="/Turkey/list_send_mail">  <input type="button" value="보낸쪽지" style="width:100px;margin-top:50px;"></a>
				<a href="/Turkey/list_mail"><input type="button" value="받은쪽지" style="width:100px;margin-top:50px;"></a>
				<a href="/Turkey/send_mail"><input type="button" value="쪽지전송" style="width:100px;margin-top:50px;"></a><br><br>
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
				보낸 쪽지함
			</div>
		
			<div class="post_check_stu_miniheader_search_form">
				
				<form>
					<div class="post_check_adm_miniheader_search_form_result">
						<table style="text-align:center;">
						<colgroup>
							<col width="100px">
							<col width="300px">
							<col width="100px">
						</colgroup>
						<tr>
								<th style="border-right:0.5px solid #000; font-size:14px;">보낸사람</th>
								<th style="border-right:0.5px solid #000; font-size:14px;">내용</th>
								<th style="font-size:14px;">날짜</th>
							</tr>
						<colgroup>
							<col width="100px">
							<col width="300px">
							<col width="100px">
						</colgroup>
						<c:forEach var="sendmail" items="${send_mail_list}">
							<tr>
								<th style="border-right:0.5px solid #000; font-size:14px;">${sendmail.sending}</th>
								<th style="border-right:0.5px solid #000; font-size:14px;">${sendmail.contents}</th>
								<th style="font-size:14px;">${sendmail.regdate.substring(0,10)}</th>
							</tr>
						</c:forEach>
					</table>
					</div>
				</form>
				<a href="/Turkey/list_send_mail">  <input type="button" value="보낸쪽지" style="width:100px;margin-top:50px;"></a>
				<a href="/Turkey/list_mail"><input type="button" value="받은쪽지" style="width:100px;margin-top:50px;"></a>
				<a href="/Turkey/send_mail"><input type="button" value="쪽지전송" style="width:100px;margin-top:50px;"></a><br><br>
			</div>
	</c:if>
</div>
		