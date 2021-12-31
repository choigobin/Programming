<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<script>
function modi() {
	if(pro.pro_pw.value == "" )
	{
		alert('변경하실 비밀번호를 입력하세요');
		pro.pro_pw.focus();
		return;
	}
	if(pro.pro_pw.value != pro.pro_pw2.value)
	{
		alert('비밀번호가 일치하지 않습니다.');
		pro.pro_pw2.focus();
		return;
	}
	alert("비빌변호가 변경 되었습니다.");
	pro.submit();
}

</script>


<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_pro">
		<div class="navi">
			<ul>
				<li style="background-color: #FFF;"><a href="/Turkey/pro_view" style="color: #CC3D3D;">정보 조회</a></li>
				<li><a href="/Turkey/pro_class">강의 관리</a></li>
				<li><a href="/Turkey/pro_student">학생 관리</a></li>
				<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			</ul>
		</div>
	</div>
	
	<div class="contents">
			<div class="contents_inform_view">
				<div class="contents_inform_view_detail">
				<div class="pro_pass_edit_name">* 비밀번호 변경</div>
				<div class="adm_manage_contents_main_detail_third" style="height:120px;">
					<form name="pro" method="post" action="pro_modi_pass" enctype="multipart/form-data">
						<table>
							<tr>
								<th>비밀번호 변경</th>
								<td><input type="password" name="pro_pw" placeholder="변경할 비밀번호"></td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" name="pro_pw2" placeholder="비밀번호 확인"></td>
							</tr>
						</table>
					</form>
				</div>
				<br>
				<div class="pro_manage_contents_main_detail_send">
					<input type="button" value="수정" onclick="modi()">
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>