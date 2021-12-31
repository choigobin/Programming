<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_adm">
		<div class="navi">
			<ul>
				<li><a href="/Turkey/admin_stu_view">학생 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/admin_pro_view" style="color: #598700;">교수 관리</a></li>
				<li><a href="/Turkey/major_insert">학과 관리</a></li>
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li><a href="/Turkey/illjung_insert">일정 관리</a></li>
			</ul>
		</div>
	</div>
	
	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu_select">
				<a href="admin_pro_view">교수 정보 조회</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="admin_pro_insert">교수 정보 등록</a>
			</div>
		</div>

		<form name="professor" method="post" action="admin_pro_view2" enctype="multipart/form-data">
			<div class="adm_manage_contents_main">
				<div class="adm_manage_contents_main_detail">
					<div class="adm_manage_contents_main_detail_search" >
						<select name="major">
							<option value="0" <c:if test="${map.major == '0'}">selected</c:if>>학과 전체
							<c:forEach items="${list}" var = "MajorVO">
								<option value="${MajorVO.major_code}" <c:if test="${MajorVO.major_code == map.major}">selected</c:if> >${MajorVO.major_name}학과
							</c:forEach>
						</select>
						<input type="button" value="조회" onclick="search()">
					</div>
					<div class="adm_manage_contents_main_detail_cate">
						<table>
							<tr>
								<th>교수번호</th>
								<th>이름</th>
								<th>학과</th>
								<th style="border-right: none;">직책</th>
							</tr>
						</table>
					</div>
					<div class="adm_manage_contents_main_detail_result">				
						<table>
						<c:forEach items="${list1}" var = "ProfessorVO">
							<tr>
								<td><a href="admin_pro_modi?pro_code=${ProfessorVO.pro_code}">${ProfessorVO.pro_code}</a></td>
								<td>${ProfessorVO.pro_name}</td>
								<td>${ProfessorVO.major_name}</td>							
								<td style="border-right: none;">
									<c:choose>
										<c:when test="${(ProfessorVO.pro_grade eq 1)}">기본</c:when>
										<c:when test="${(ProfessorVO.pro_grade eq 2)}">학과장</c:when>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>

	function search()
	{
	   	professor.submit();
	}	
</script>
