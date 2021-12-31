<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="../css/turkey_style.css?ver=6" rel="stylesheet">

<title>Turkey University</title>

	<div class="post_check" onresize="parent.resizeTo(500,400)" onload="parent.resizeTo(500,400)">
		<div class="post_check_stu_miniheader">
			<img src="../img/turkey_stu.png">
			<div class="post_check_stu_miniheader_name">Turkey University</div>
			<div class="post_check_stu_miniheader_description">JSL Information Portal System</div>
		</div>
		<div class="post_check_stu_miniheader_search_name">
			댓글 수정
		</div>
		<div class="post_check_stu_miniheader_search_form">
			<form name="comment" method="post" action="comment_modify">
				<textarea name="comments" style="resize:none; width:350px; height:250px; margin-bottom:20px;">${comment.comments }</textarea>
				<input type="hidden" name="c_idx" value="${comment.c_idx }">
				<input type="button" value="수정" onclick="check()"><br><br>
			</form>
		</div>
	</div>

	<script>
		function check() {
			if(comment.comments.value == ""){
				alert("내용을 입력하여 주세요.");
				comment.comments.focus();
				return;
			}
			comment.submit();
		}
		
	</script>
	
	<c:choose>
		<c:when test="${check_num != null}">
			<script>
				window.opener.location.reload();
				window.close(); 
			</script>
		</c:when>
	</c:choose>