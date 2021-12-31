<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<script>
function modi() {
	if(st.stu_pw.value != st.stu_pw2.value){
		alert('비밀번호가 일치하지 않습니다.');
		st.stu_pw2.focus();
		return false;
	}
	st.submit();
}

</script>

<c:if test="${row == 1 }">
	<script>
		alert("수정 되었습니다.")
	</script>
</c:if>

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_stu">
		<ul>
			<li style="background-color: #FFF;"><a href="/Turkey/student_view" style="color: #2F5597;">정보 조회</a></li>
			<li><a href="/Turkey/student_score">성적 조회</a></li>
			<li><a href="/Turkey/student_sub_cal">시간표 조회</a></li>
			<li><a href="/Turkey/student_attendance">출결 조회</a></li>
			<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			<li><a href="/Turkey/student_apply">수강신청</a></li>
		</ul>
	</div>

	<div class="contents">
		<div class="contents_inform_view_stu">
			<div class="contents_inform_view_detail">
				<div class="pro_pass_edit_name">* 비밀번호 변경</div>
				<div class="adm_manage_contents_main_detail_third" style="height:120px;">
					<form name="st" method="post" action="student_modify">
						<table>
							<tr>
								<th>비밀번호 변경</th>
								<td><input type="password" name="stu_pw"></td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" name="stu_pw2"></td>
							</tr>
						</table>
					</form>
				</div>
				<br>
				<div class="stu_manage_contents_main_detail_send" style="padding-right:460px;">
					<input type="button" value="수정" onclick="modi()">
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>