<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<c:if test="${pro_vo != null}">
	<%@ include file="../include/navigation_pro.jsp"%>
	</c:if>
	<div class="stu_contents">
		<div class="stu_contents_a">
			<div class="stu_contents_a_logform">
				<div class="stu_contents_a_logform_name">${pro_vo.pro_name}</div>
				<div class="stu_contents_a_logform_major">
					<b>${pro_vo.major_code }</b> 전공<br> <b>${pro_vo.pro_grade }</b> 교수<br>
				</div>
				<div class="stu_contents_a_logform_message">
					새로운 쪽지 <b>5</b> 건
				</div>
			</div>
			<div class="stu_contents_a_schedule">
				<div class="stu_contents_a_schedule_name">학사 일정</div>
				<div class="stu_contents_a_schedule_select_day"></div>
				<div class="stu_contents_a_schedule_select_year">
					<select name="schedule_year">
						<option value="2018">2018
						<option value="2019">2019
						<option value="2020" selected>2020
						<option value="2021">2021
						<option value="2022">2022
					</select>
				</div>
				<div class="stu_contents_a_schedule_select_month">
					<select name="schedule_month">
						<option value="01">01
						<option value="02">02
						<option value="03">03
						<option value="04">04
						<option value="05">05
					</select>
				</div>
				<div class="stu_contents_a_schedule_dashed_line"></div>
				<div class="stu_contents_a_schedule_description">* 등록된 일정이
					없습니다.</div>
			</div>
		</div>
		<div class="stu_contents_b">
			<div class="stu_contents_b_notice">
				<div class="stu_contents_b_notice_name">■ 공지 사항</div>
				<div class="stu_contents_b_notice_title">
					* notice_title
					<div class="stu_contents_b_notice_regdate">2020.07.15</div>
				</div>
			</div>

			<div class="stu_contents_b_board">
				<div class="stu_contents_b_board_name">■ 자유게시판</div>
				<div class="stu_contents_b_board_title">
					* board_title
					<div class="stu_contents_b_board_regdate">2020.07.15</div>
				</div>

			</div>
			<div class="stu_contents_b_board_2">
				<div class="stu_contents_b_board_2_name">■ 자유게시판</div>
				<div class="stu_contents_b_board_2_title">
					* board_title
					<div class="stu_contents_b_board_2_regdate">2020.07.15</div>
				</div>

			</div>
		</div>

		<div class="stu_contents_c">
			<div class="stu_contents_c_inform">
				<div class="stu_contents_c_inform_name">강의 정보</div>
				<div class="stu_contents_c_inform_score">
					<div class="stu_contents_c_inform_score_f">
						담당 강의 : <b>8</b><br> 담당 학생 수 : <b>128</b><br>
					</div>
				</div>
			</div>
			<div class="stu_contents_c_time_schedule">
				<div class="stu_contents_c_time_schedule_name">시간표</div>
				<div class="stu_contents_c_time_schedule_time"></div>
				<div class="stu_contents_c_time_schedule_dashed_line"></div>
				<div class="stu_contents_c_time_schedule_description">
					과목명 : <b>경영학의 이해</b><br> 위치 : <b>050403</b><br> 교수명 : <b>죄문환</b><br>
					출석률 : <b>87</b>%<br>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../include/footer.jsp"%>

</div>