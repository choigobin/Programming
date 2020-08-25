<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_adm">
		<div class="navi">
			<ul>
				<li><a href="admin_stu_view">학생 관리</a></li>
				<li><a href="admin_pro_view">교수 관리</a></li>
				<li><a href="/Turkey/major_insert">학과 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/subject_insert" style="color: #598700;">과목 관리</a></li>
				<li><a href="/Turkey/illjung_insert">일정 관리</a></li>
			</ul>
		</div>
	</div>

	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/subject_insert">과목 등록</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/subject_list">과목 리스트</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/subject2_list">개설된 과목 조회</a>
			</div>

		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_third">
					<form name="sub_insert" method="post" action="subject_insert">
						<table>
							<tr>
								<th>과목 코드</th>
								<td>
									<input type="text" name="sub_code">
								</td>
								<th>과목 이름</th>
								<td>
									<input type="text" name="sub_name">
								</td>
							</tr>
							<tr>
								<th>이수 학점</th>
								<td>
									<input type="text" name="sub_credit">
								</td>
								<th>개설 학과</th>
								<td>
									<select name="major_code">
										<option value="">개설 학과 선택</option>
										<c:forEach var="major" items="${major_list}">
											<option value="${major.major_code}">${major.major_name} , ${major.major_code}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align:right;">
									<input type="button" value="등록" onclick="send()" style="width:160px; height:38px; margin-right:210px; margin-top:14px;">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function send() {
		if(sub_insert.sub_code.value == ""){
			alert("과목 코드를 입력 해주세요");
			sub_insert.sub_code.focus();
			return;
		}
		if(sub_insert.sub_name.value == ""){
			alert("과목 이름를 입력 해주세요");
			sub_insert.sub_name.focus();
			return;
		}
		if(sub_insert.major_code.value == ""){
			alert("개설학과를 선택하세요");
			sub_insert.major_code.focus();
			return;
		}
		sub_insert.submit();
	}
</script>