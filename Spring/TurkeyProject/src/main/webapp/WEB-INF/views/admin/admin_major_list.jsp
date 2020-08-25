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
				<li style="background-color: #FFF;"><a href="/Turkey/major_insert" style="color: #598700;">학과 관리</a></li>
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li><a href="/Turkey/illjung_insert">일정 관리</a></li>
			</ul>
		</div>
	</div>

	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/major_insert">학과 등록</a>
			</div>
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/major_list">학과 리스트</a>
			</div>

		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_forth" style="padding-top:40px;">
					<table>
						<tr>
							<th>학과 코드</th>
							<th style="border-right: none;">학과 이름</th>
						</tr>
					</table>
				</div>
				<div class="adm_manage_contents_main_detail_fifth">				
					<table>
						<c:forEach var="major" items="${major_list}">
							<tr>
								<td>
									${major.major_code}
								</td>
								<td style="border-right: none;">
									${major.major_name}학과
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function send() {
		if(major_insert.major_code.value==""){
			alert("학과코드 입력 하세요");
			major_insert.major_code.focus();
			return;
		}
		if(major_insert.major_name.value==""){
			alert("학과이름 입력 하세요");
			major_insert.major_name.focus();
			return;
		}
		alert("학과 정보를 등록 합니다.");
		major_insert.submit();
	}
</script>