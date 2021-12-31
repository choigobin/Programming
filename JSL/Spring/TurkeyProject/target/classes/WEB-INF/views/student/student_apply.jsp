<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<script>
	${alert}
</script>

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_stu">
		<ul>
			<li><a href="/Turkey/student_view">정보 조회</a></li>
			<li><a href="/Turkey/student_score">성적 조회</a></li>
			<li><a href="/Turkey/student_sub_cal">시간표 조회</a></li>
			<li><a href="/Turkey/student_attendance">출결 조회</a></li>
			<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			<li style="background-color: #FFF;"><a href="/Turkey/student_apply" style="color: #2F5597;">수강신청</a></li>
		</ul>
	</div>

	<div class="contents">
			<div class="contents_inform_view_stu">
				<div class="contents_inform_view_detail">
				<div class="stu_detail_search">
					<form name="applyForm" method="post" action="student_apply">
						<select name="year">
							<option value="0">년도선택
							<option value="2016" <c:if test="${year == 2016}">selected</c:if>>2016

							
							<option value="2017" <c:if test="${year == 2017}">selected</c:if>>2017

							
							<option value="2018" <c:if test="${year == 2018}">selected</c:if>>2018

							
							<option value="2019" <c:if test="${year == 2019}">selected</c:if>>2019

							
							<option value="2020" <c:if test="${year == 2020}">selected</c:if>>2020

							
						</select> <select name="semester">
							<option value="0">학기선택
							<option value="1" <c:if test="${semester == 1}">selected</c:if>>1학기

							
							<option value="2" <c:if test="${semester == 2}">selected</c:if>>2학기

							
						</select> <select name="major_code">
							<option value="0">학과선택
								<c:forEach var="major" items="${major_list}">
									<option value="${major.major_code}"
										<c:if test="${major.major_code == major_code}">selected</c:if>>${major.major_name}
								</c:forEach>
						</select> <input type="button" value="조회" onclick="send()">
					</form>
				</div>

				<form name="applyForm2" method="post" action="student_apply_do">
					<div class="pro_detail_forth">
					<div class="adm_contents_in">
							<table>
								<colgroup>
									<col width="90px">
									<col width="200px">
									<col width="90px">
									<col width="50px">
									<col width="90px">
									<col width="80px">
									<col width="80px">
									<col width="80px">
									<col width="80px">
								</colgroup>
								<tr>

									<th>과목코드</th>
									<th>과목이름</th>
									<th>이수구분</th>
									<th>학점</th>
									<th>담당교수</th>
									<th>정원</th>
									<th>현원</th>
									<th>시간A</th>
									<th style="border-right: none;">시간B</th>
								</tr>
								<c:forEach var="sub2" items="${sub2_list}">
									<tr>
										<td>${sub2.sub_code }</td>
										<td><a
											href="/Turkey/student_apply_do?sub_code=${sub2.sub_code}
											&stu_code=${stu_vo.stu_code}&major_code=${sub2.major_code}
											&year=${year}&semester=${semester}">${sub2.sub_name}</a>
										</td>
										<c:if test="${sub2.gubun eq 'gyo'}">
											<td>교양</td>
										</c:if>
										<c:if test="${sub2.gubun eq 'jeon'}">
											<td>전공</td>
										</c:if>
										<td>${sub2.sub_credit}</td>
										<td>${sub2.pro_name}</td>
										<td>${sub2.max_inwon}</td>
										<td>${sub2.inwon}</td>
										<td>${sub2.time_a}</td>
										<td style="border-right: none;">${sub2.time_b}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function send() {
		if (applyForm.year.value == "0") {
			alert("년도를 선택 해 주세요");
			applyForm.year.focus();
			return;
		}
		if (applyForm.semester.value == "0") {
			alert("학기를 선택 해 주세요");
			applyForm.semester.focus();
			return;
		}
		if (applyForm.major_code.value == "0") {
			alert("개설학과를 선택 해 주세요");
			applyForm.major_code.focus();
			return;
		}

		applyForm.submit();
	}

	function send2() {
		if (confirm("해당 과목을 신청하시겠습니까?") == true) {
			applyForm2.submit();
		} else {
			return;
		}
	}
</script>