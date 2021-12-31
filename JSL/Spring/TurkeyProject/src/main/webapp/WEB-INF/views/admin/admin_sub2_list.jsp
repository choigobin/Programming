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
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/subject_insert">과목 등록</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/subject_list">과목 리스트</a>
			</div>
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/subject2_list">개설된 과목 조회</a>
			</div>
		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<form name="sub2_list" method="post" action="subject2_list">
					<div class="adm_manage_contents_main_detail_search">
						<select name="major_code">
							<option value="">개설 학과 선택</option>
								<c:forEach var="major" items="${major_list}">
									<option value="${major.major_code}">
										${major.major_name}
									</option>
								</c:forEach>
						</select>
						<select name="year">
							<option value="">개설 년도 선택</option>
							<option value="2020">2020</option>
							<option value="2019">2019</option>
						</select>
						<select name="semester">
							<option value="">학기 선택</option>
							<option value="1">1학기</option>
							<option value="2">2학기</option>
						</select>
						<input type="button" value="검색" onclick="send()" style="width:125px;">
					</div>
				</form>
				<div class="adm_manage_contents_main_detail_forth">
					<table>
						<tr>
							<th>과목 코드</th>
							<th>과목명</th>
							<th>학과 코드</th>
							<th>담당 교수</th>
							<th>시간 1</th>
							<th>시간 2</th>
							<th>인원</th>
							<th>정원</th>
							<th>개설 년도</th>
							<th>개설 학기</th>
							<th>수업 구분</th>
							<th style="border-right: none;">이수 학점</th>
						</tr>
						<c:if test="${empty sub2_list}">
							<tr>
								<td colspan="12" style="border-right: none;">개설된 과목이 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${!empty sub2_list}">
							<c:forEach var="sub2" items="${sub2_list}">
								<tr>
									<td>${sub2.sub_code}</td>
									<td>${sub2.sub_name}</td>
									<td>${sub2.major_code}</td>
									<td>${sub2.pro_name}</td>
									<td>${sub2.time_a}</td>
									<td>${sub2.time_b}</td>
									<td>${sub2.inwon}</td>
									<td>${sub2.max_inwon}</td>
									<td>${sub2.year}</td>
									<td>${sub2.semester}</td>
									<c:if test="${sub2.gubun eq 'gyo'}">
										<td>교양</td>
									</c:if>
									<c:if test="${sub2.gubun eq 'jeon'}">
										<td>전공</td>
									</c:if>
									<td style="border-right: none;">${sub2.sub_credit}</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function send() {
		if(sub2_list.major_code.value == ""){
			alert("개설 학과를 입력 해주세요");
			sub2_list.major_code.focus();
			return;
		}
		if(sub2_list.year.value == ""){
			alert("개설 년도를 입력 해주세요");
			sub2_list.year.focus();
			return;
		}
		if(sub2_list.semester.value == ""){
			alert("개설 학기를 입력 해주세요");
			sub2_list.semester.focus();
			return;
		}
		sub2_list.submit();
	}
	
	function touroku(){
		
	}
</script>