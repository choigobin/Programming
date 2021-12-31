<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
 	function stu_search() {
		if (stu.list_year.selectedIndex==0) {
			alert('조회하실 년도를 선택해주세요');
			return false;
		}
		if (stu.list_semester.selectedIndex==0) {
			alert('조회하실 학기를 선택해주세요');
			return false;
		}
		stu.submit();

	} 
	 
</script>

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_stu">
		<ul>
			<li><a href="/Turkey/student_view">정보 조회</a></li>
			<li style="background-color: #FFF;"><a href="/Turkey/student_score" style="color: #2F5597;">성적 조회</a></li>
			<li><a href="/Turkey/student_sub_cal">시간표 조회</a></li>
			<li><a href="/Turkey/student_attendance">출결 조회</a></li>
			<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			<li><a href="/Turkey/student_apply">수강신청</a></li>
		</ul>
	</div>

	<div class="contents">
			<div class="contents_inform_view_stu">
				<div class="contents_inform_view_detail">
				<div class="stu_detail_search">
					<form name="stu" action="student_score" method="post">
						<select name="list_year">
				
							<option value="-1">년도선택
							<option value="0">전체
								<c:forEach var="list" items="${list}">
									<option value="${list.list_year}" />${list.list_year}
								</c:forEach>
						</select> 
						<select name="list_semester">
							<option value="-1">학기선택
							<option value="0">전체
							<option value="1">1학기
							<option value="2">2학기
						</select>
						 <input type="button" value="조회" onClick="stu_search()">
					</form>
				</div>
				<div class="pro_detail_forth">
					<div class="adm_contents_in">
					<table>
						<colgroup>
							<col width="90px">
							<col width="90px">
							<col width="155px">
							<col width="200px">
							<col width="155px">
							<col width="90px">
							<col width="90px">
						</colgroup>
						<tr>
							<th>년도</th>
							<th>학기</th>
							<th>과목번호</th>
							<th>과목이름</th>
							<th>이수구분</th>
							<th>학점</th>
							<th style="border-right: none !important">등급</th>
						</tr>
						<c:forEach var="list2" items="${list2}">
							<tr>
							<td>${list2.list_year}</td>
							<td>${list2.list_semester}</td>
							<td>${list2.sub_code}</td>
							<td>
							<%-- <a href="student_score_evaluation?stu_vo.stu_code=${stu_vo.stu_code}" onclick="window.open(this.href,'','width=510, height=300, scrollbars=no'); return false;" href="student_score_evaluation"></a> --%>
								${list2.sub_name}</td>
							<td>
								<c:if test="${list2.gubun eq 'gyo'}">교양</c:if>
								<c:if test="${list2.gubun eq 'jeon'}">전공</c:if>
							</td>
							<td>${list2.list_score}</td>
							
							<td style="border-right: none !important">
							<c:if test="${fn:trim(list2.list_score eq '4.5')}">A+</c:if>
							<c:if test="${fn:trim(list2.list_score >= '4.3' && list2.list_score < '4.5')}">A</c:if>
							<c:if test="${fn:trim(list2.list_score >= '4.0' && list2.list_score < '4.3')}">A-</c:if>
							<c:if test="${fn:trim(list2.list_score >= '3.5' && list2.list_score < '4.0')}">B+</c:if>
							<c:if test="${fn:trim(list2.list_score >= '3.3' && list2.list_score < '3.5')}">B</c:if>
							<c:if test="${fn:trim(list2.list_score >= '3.0' && list2.list_score < '3.3')}">B-</c:if>
							<c:if test="${fn:trim(list2.list_score >= '2.5' && list2.list_score < '3.0')}">C+</c:if>
							<c:if test="${fn:trim(list2.list_score >= '2.3' && list2.list_score < '2.5')}">C</c:if>
							<c:if test="${fn:trim(list2.list_score >= '2.0' && list2.list_score < '2.3')}">C-</c:if>
							<c:if test="${fn:trim(list2.list_score >= '1.0' && list2.list_score < '2.0')}">F</c:if>
							
							
							</td>
						</tr>
						</c:forEach>
					</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

	<!-- 
						4.5 : A+
						4.3 : A
						4.0 : A-
						3.5 : B+
						3.3 : B
						3.0 : B-
						2.5 : C+
						2.3 : C
						2.0 : C-
						
						
						1 - 전필: 전공 필수 (전공과목이며 필수로 들어야 함)
						2 - 전선: 전공 선택 (전공 과목이지만 선택적으로 들을 수 있음)
						3 - 교필: 교양 필수 (교양 과목이며 필수적으로 들어야함- 모든 과에 해당되는 경우가 다수!!)
						4 - 교선: 교양 선택 (교양과목이고 선택적으로 들어야함)
						 -->