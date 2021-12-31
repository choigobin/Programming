<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_pro">
		<div class="navi">
			<ul>
				<li><a href="/Turkey/pro_view">정보 조회</a></li>
				<li><a href="/Turkey/pro_class">강의 관리</a></li>
				<li><a href="/Turkey/pro_student">학생 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/illjung_list2" style="color: #CC3D3D;">학사일정</a></li>
			</ul>
		</div>
	</div>

	<div class="contents">
			<div class="contents_inform_view">
				<div class="contents_inform_view_detail">
				<div class="pro_detail_search">
						<form name="illjung_year_select_form" method="post" action="illjung_list2">
							<select name="year">
								<option value="0">연도 선택</option>
								<option value="2019">2019</option>
								<option value="2020" selected>2020</option>
							</select>
							<input type="button" value="검색" onclick="send()" style="width:125px; margin-right:400px;">
						</form>
					</div>
				<div class="pro_detail_forth" style="padding-top:15px;">
					<table>
						<tr>
							<th>날짜</th>
							<th style="border-right: none;">일정 내용</th>
						</tr>
						<c:if test="${empty ill_list}">
							<tr>
								<td colspan="2">등록된 일정이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="ill" items="${ill_list}">
							<tr>
								<td>
									${ill.day.substring(0,10)}
								</td>
								<td style="border-right: none;">${ill.contents}
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