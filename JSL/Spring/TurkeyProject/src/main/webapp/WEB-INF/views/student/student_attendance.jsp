<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
 	function stu_send() {
		if (stu.year.selectedIndex==0) {
			alert('조회하실 년도를 선택해주세요');
			return false;
		}
		if (stu.semester.selectedIndex==0) {
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
			<li><a href="/Turkey/student_score">성적 조회</a></li>
			<li><a href="/Turkey/student_sub_cal">시간표 조회</a></li>
			<li style="background-color: #FFF;"><a href="/Turkey/student_attendance" style="color: #2F5597;">출결 조회</a></li>
			<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			<li><a href="/Turkey/student_apply">수강신청</a></li>
		</ul>
	</div>

	<div class="contents">
			<div class="contents_inform_view_stu">
				<div class="contents_inform_view_detail">
				<div class="stu_detail_search">
					<form name="stu" action="student_attendance" method="post">
						<select name="year">
							<option value="-1">년도선택
							<option value="0">전체
								<c:forEach var="list" items="${list}">
									<option value="${list.year}" />${list.year}
								</c:forEach>
						</select> 
						<select name="semester">
							<option value="-1">학기선택
							<option value="0">전체
							<option value="1">1학기
							<option value="2">2학기
						</select>
						 <input type="button" value="조회" onClick="stu_send()">
					</form>
				</div>

				<div class="pro_detail_forth">
					<div class="adm_contents_in">
					<table style="width:1055px;">
						<colgroup>
							<col width="100px;">
						</colgroup>
						<tr>
							<th style="font-size:13px;">과목<br>이름</th>
							<th style="font-size:13px;">교수<br>이름</th>
							<th style="font-size:13px;">요일<br>/교시</th>
							<th style="font-size:13px;">1</th>
							<th style="font-size:13px;">2</th>
							<th style="font-size:13px;">3</th>
							<th style="font-size:13px;">4</th>
							<th style="font-size:13px;">5</th>
							<th style="font-size:13px;">6</th>
							<th style="font-size:13px;">7</th>
							<th style="font-size:13px;">8</th>
							<th style="font-size:13px;">9</th>
							<th style="font-size:13px;">10</th>
							<th style="font-size:13px;">11</th>
							<th style="font-size:13px;">12</th>
							<th style="font-size:13px;">13</th>
							<th style="font-size:13px;">14</th>
							<th style="font-size:13px; border-right:none;">15</th>
						</tr>
						<c:forEach var="list2" items="${list2}">
						<tr>
							<td style="font-size:13px;">${list2.sub_name}</td>
							<td style="font-size:13px;">${list2.pro_name}</td>
							<td style="font-size:13px;">
								<c:choose>
									<c:when test="${list2.att_time.substring(0,1) eq 'A'}">월</c:when>
									<c:when test="${list2.att_time.substring(0,1) eq 'B'}">화</c:when>
									<c:when test="${list2.att_time.substring(0,1) eq 'C'}">수</c:when>
									<c:when test="${list2.att_time.substring(0,1) eq 'D'}">목</c:when>
									<c:when test="${list2.att_time.substring(0,1) eq 'E'}">금</c:when>	
								</c:choose>
								/
								<c:choose>
									<c:when test="${list2.att_time.substring(1,2) eq '1'}">1</c:when>
									<c:when test="${list2.att_time.substring(1,2) eq '2'}">2</c:when>
									<c:when test="${list2.att_time.substring(1,2) eq '3'}">3</c:when>
									<c:when test="${list2.att_time.substring(1,2) eq '4'}">4</c:when>
									<c:when test="${list2.att_time.substring(1,2) eq '5'}">5</c:when>
								</c:choose>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week1 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week1 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week1 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week1 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week2 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week2 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week2 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week2 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week3 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week3 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week3 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week3 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week4 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week4 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week4 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week4 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week5 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week5 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week5 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week5 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week6 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week6 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week6 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week6 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week7 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week7 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week7 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week7 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week8 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week8 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week8 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week8 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week9 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week9 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week9 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week9 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week10 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week10 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week10 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week10 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week11 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week11 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week11 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week11 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week12 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week12 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week12 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week12 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week13 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week13 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week13 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week13 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week14 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week14 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week14 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week14 eq null)}">◆</c:if>
							</td>
							<td style="font-size:10px;">
							<c:if test="${fn:trim(list2.week15 eq 'C')}">○</c:if>
							<c:if test="${fn:trim(list2.week15 eq 'L')}">△</c:if>
							<c:if test="${fn:trim(list2.week15 eq 'A')}">▽</c:if>
							<c:if test="${fn:trim(list2.week15 eq null)}">◆</c:if>
							</td>
						</tr>
						</c:forEach>
					</table>
					</div>
					<br>
					<font style="padding-right:25px; float:right; font-size:12px;">* ○&nbsp;출석 | △ &nbsp;지각 | ▽ &nbsp;결석 | ◆ &nbsp;미정</font>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

