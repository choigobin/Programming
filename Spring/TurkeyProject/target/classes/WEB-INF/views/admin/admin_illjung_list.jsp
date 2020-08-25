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
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/illjung_insert" style="color: #598700;">일정 관리</a></li>
			</ul>
		</div>
	</div>

	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/illjung_insert">일정 등록</a>
			</div>
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/illjung_list">일정 리스트</a>
			</div>
		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_search" >
						<form name="illjung_year_select_form" method="post" action="illjung_list">
							<select name="year">
								<option value="0">연도 선택</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
							</select>
							<input type="button" value="검색" onclick="send()">
						</form>
					</div>
				<div class="adm_manage_contents_main_detail_cate">
					<table>
						<tr>
							<th>일정 날짜</th>
							<th style="border-right: none;">일정 내용</th>
						</tr>
					</table>
				</div>
				<div class="adm_manage_contents_main_detail_result">				
					<table>
						<c:if test="${empty ill_list}">
							<tr>
								<th>등록된 일정이 없습니다.</th>
							</tr>
						</c:if>
						<c:forEach var="ill" items="${ill_list}">
							<tr>
								<td>
									${ill.day.substring(0,10)}
								</td>
								<td style="border-right: none;">
									<a href="/Turkey/illjung_delete?idx=${ill.idx}">${ill.contents}</a>
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
		if(illjung_year_select_form.year.value==""){
			alert("연도를 선택해 주세요");
			major_insert.year.focus();
			return;
		}

		illjung_year_select_form.submit();
	}
</script>