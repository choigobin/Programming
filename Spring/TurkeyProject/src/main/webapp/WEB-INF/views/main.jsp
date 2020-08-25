<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link href="../css/all_style.css?ver=10" rel="stylesheet">

<div class="all">

	<%@ include file="include/header.jsp"%>

	<!-- 학생 -->
	<c:if test="${stu_vo != null}">

		<%@ include file="include/navigation_stu.jsp"%>

		<div class="contents">
					<div class="stu_main_a">
						<div class="stu_main_a_inform">
							<div class="stu_main_a_inform_name">${stu_vo.stu_name}</div>
					<div class="stu_main_a_inform_major">
						<b>${stu_vo.major_name}</b> <br> <b>${stu_vo.stu_level}</b>
						학년 [
						<c:if test="${stu_vo.stu_condition == 1}">
							<b>재학</b>
						</c:if>
						<c:if test="${stu_vo.stu_condition == 2}">
							<b>휴학</b>
						</c:if>
						<c:if test="${stu_vo.stu_condition == 3}">
							<b>졸업</b>
						</c:if>
						<c:if test="${stu_vo.stu_condition == 4}">
							<b>자퇴</b>
						</c:if>
						]<br>
					</div>
					<div class="stu_main_a_inform_message">
						<a href="javascript:list_mail()">새로운 쪽지 <b>${mail_count}</b> 건
						</a>
					</div>
				</div>
				<form name="date" method="post" action="main_1" enctype="multipart/form-data">
					<div class="stu_main_a_schedule">
						<div class="stu_main_a_schedule_name">학사 일정</div>
						<div class="stu_main_a_schedule_select_day" id="Date" onChange="schedule(this)">
							<input type="hidden" name="schedule_2" value="${date}"> <input type="hidden" name="day" value="${time1}" id="day2">
						</div>
						<div class="stu_main_a_schedule_dashed_line"></div>
						<div class="stu_main_a_schedule_description">
							${time} <br>
							<c:if test="${empty list}">* 등록된 일정이 없습니다.</c:if>
							<c:forEach items="${list}" var="ILLJUNGVO">
								<c:if test="${(not empty ILLJUNGVO)}">* ${ILLJUNGVO.contents} 
											
						<br>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</form>
			</div>
			<div class="stu_main_b">
					<div class="stu_main_b_notice">
						<div class="stu_main_b_notice_name">공지 사항
							<div class="stu_main_b_notice_more"><a href="/Turkey/notice_list?page=1">more</a></div>
						</div>
						<div class="adm_main_b_notice_title">
							<c:forEach var="main_notice" items="${notice_board_list}">
								* <a href="/Turkey/notice_readcnt?search=1&key=1&idx=${main_notice.idx}&page=1">${main_notice.title}</a>
								<div class="adm_main_b_notice_regdate">${main_notice.regdate.substring(0,10)}</div>
								<br>
							</c:forEach>
						</div>
					</div>
	
						<div class="stu_main_b_board">
								<div class="stu_main_b_notice_name">자유 게시판
								<div class="stu_main_b_notice_more"><a href="/Turkey/board_list?page=1">more</a></div>
							</div>
	
							<div class="adm_main_b_board_title">
								<c:forEach var="main_free" items="${free_board_list}">	
									* <a href="/Turkey/board_readcnt?search=1&key=1&idx=${main_free.idx}&page=1">${main_free.title}</a>
									<div class="adm_main_b_board_regdate">${main_free.regdate.substring(0,10)}</div>
									<br>
								</c:forEach>
							</div>
						</div>
					</div>

			<div class="stu_contents_c">
				<div class="stu_contents_c_inform">
					<div class="stu_contents_c_inform_name">학사 정보</div>
					<div class="stu_contents_c_inform_score">
						<div class="stu_contents_c_inform_score_f">
							이수 학기 : <b>${stu_vo.stu_level*2}</b><br> 총 이수 학점 : <b>${stu_vo.stu_jeon + stu_vo.stu_gyo}</b><br>
							전공 이수 학점 : <b>${stu_vo.stu_jeon}</b><br> 교양 이수 학점 : <b>${stu_vo.stu_gyo}</b><br>
						</div>
					</div>
				</div>
				<div class="stu_contents_c_time_schedule">
					<div class="stu_contents_c_time_schedule_name" style="margin-bottom:-10px;">
						시간표<span style="font-size: 11px;"> (2020년 1학기 기준)</span>
					</div>
					<%@ include file="student/student_main_cal.jsp"%>
					<div class="stu_contents_c_time_schedule_dashed_line"></div>
					<div class="stu_contents_c_time_schedule_description" style="font-size:12px;">
						과목명 :
						<c:forEach var="list2" items="${list2}">
							<b>${list2.sub_name}</b>
							<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:if>


	<c:if test="${pro_vo != null}">

		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">

			<%@ include file="include/navigation_adm.jsp"%>

			<div class="contents">
				<div class="adm_main">
					<div class="adm_main_a">
						<div class="adm_main_a_inform">
							<div class="adm_main_a_inform_name">${pro_vo.pro_name}</div>
							<div class="adm_main_a_inform_message">
								<a href="javascript:list_mail()">새로운 쪽지 <b>${mail_count}</b> 건
								</a>
							</div>
						</div>
						<form name="date" method="post" action="main_1" enctype="multipart/form-data">
							<div class="adm_main_a_schedule">
								<div class="adm_main_a_schedule_name">학사 일정</div>
								<div class="adm_main_a_schedule_select_day" id="Date" onChange="schedule(this)">
									<input type="hidden" name="schedule_2" value="${date}">
									<input type="hidden" name="day" value="${time1}" id="day2">
								</div>
								<div class="adm_main_a_schedule_dashed_line"></div>
								<div class="adm_main_a_schedule_description"> <b>${time}</b> <br>
									<c:if test="${empty list}">* 등록된 일정이 없습니다.</c:if>
									<c:forEach items="${list}" var="ILLJUNGVO">
										<c:if test="${(not empty ILLJUNGVO)}">* ${ILLJUNGVO.contents} <br> </c:if>
									</c:forEach>
								</div>
							</div>
						</form>
					</div>
					<div class="adm_main_b">
						<div class="adm_main_b_notice">
							<div class="adm_main_b_notice_name">공지 사항
								<div class="adm_main_b_notice_more"><a href="/Turkey/notice_list?page=1">more</a></div>
							</div>
							<div class="adm_main_b_notice_title">
								<c:forEach var="main_notice" items="${notice_board_list}">
									* <a href="/Turkey/notice_readcnt?search=1&key=1&idx=${main_notice.idx}&page=1">${main_notice.title}</a>
									<div class="adm_main_b_notice_regdate">${main_notice.regdate.substring(0,10)}</div>
									<br>
								</c:forEach>
							</div>
						</div>
	
						<div class="adm_main_b_board">
								<div class="adm_main_b_board_name">자유 게시판
								<div class="adm_main_b_notice_more"><a href="/Turkey/board_list?page=1">more</a></div>
							</div>
	
							<div class="adm_main_b_board_title">
								<c:forEach var="main_free" items="${free_board_list}">	
									* <a href="/Turkey/board_readcnt?search=1&key=1&idx=${main_free.idx}&page=1">${main_free.title}</a>
									<div class="adm_main_b_board_regdate">${main_free.regdate.substring(0,10)}</div>
									<br>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<!-- 교수 -->
		<c:if test="${pro_vo.pro_code != '00000'}">
			<%@ include file="include/navigation_pro.jsp"%>

			<div class="contents">
				<div class="pro_main">
					<div class="pro_main_a">
						<div class="pro_main_a_inform">
							<div class="pro_main_a_inform_name">${pro_vo.pro_name}</div>
						<div class="pro_main_a_inform_major">
							<b>${pro_vo.major_name}</b> 소속<br> 등급 [
							<c:if test="${pro_vo.pro_grade == 1}">
								<b>기본</b>
							</c:if>
							<c:if test="${pro_vo.pro_grade == 2}">
								<b>학과장</b>
							</c:if>
							]<br>
						</div>
						<div class="pro_main_a_inform_message">
							<a href="javascript:list_mail()">새로운 쪽지 <b>${mail_count}</b>
								건
							</a>
						</div>
					</div>
					<form name="date" method="post" action="main_1"
						enctype="multipart/form-data">
						<div class="pro_main_a_schedule">
							<div class="pro_main_a_schedule_name">학사 일정</div>
							<div class="pro_main_a_schedule_select_day" id="Date" onChange="schedule(this)">
								<input type="hidden" name="schedule_2" value="${date}">
								<input type="hidden" name="day" value="${time1}" id="day2">

							</div>
							<div class="pro_main_a_schedule_dashed_line"></div>
							<div class="pro_main_a_schedule_description"> <b>${time}</b> <br>
								<c:if test="${empty list}">* 등록된 일정이 없습니다.</c:if>
								<c:forEach items="${list}" var="ILLJUNGVO">
									<c:if test="${(not empty ILLJUNGVO)}">* ${ILLJUNGVO.contents} 
											
						<br>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</form>
				</div>
				<div class="pro_main_b">
						<div class="pro_main_b_notice">
							<div class="adm_main_b_notice_name">공지 사항
								<div class="adm_main_b_notice_more"><a href="/Turkey/notice_list?page=1">more</a></div>
							</div>
							<div class="adm_main_b_notice_title">
								<c:forEach var="main_notice" items="${notice_board_list}">
									* <a href="/Turkey/notice_readcnt?search=1&key=1&idx=${main_notice.idx}&page=1">${main_notice.title}</a>
									<div class="adm_main_b_notice_regdate">${main_notice.regdate.substring(0,10)}</div>
									<br>
								</c:forEach>
							</div>
						</div>
	
						<div class="pro_main_b_board">
								<div class="adm_main_b_board_name">자유 게시판
								<div class="adm_main_b_notice_more"><a href="/Turkey/board_list?page=1">more</a></div>
							</div>
	
							<div class="adm_main_b_board_title">
								<c:forEach var="main_free" items="${free_board_list}">	
									* <a href="/Turkey/board_readcnt?search=1&key=1&idx=${main_free.idx}&page=1">${main_free.title}</a>
									<div class="adm_main_b_board_regdate">${main_free.regdate.substring(0,10)}</div>
									<br>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:if>
	<%@ include file="include/footer.jsp"%>
</div>

<script>
	function list_mail() {
		window.open("list_mail", "list_mail_form", "width=530 height=600");
	}
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$.datepicker.setDefaults($.datepicker.regional['ko']);
				$("#Date")
						.datepicker(
								{
									changeMonth : true,
									changeYear : true,
									dayNames : [ '일요일', '월요일', '화요일', '수요일',
											'목요일', '금요일', '토요일' ],
									dayNamesMin : [ '일', '월', '화', '수', '목',
											'금', '토' ],
									monthNamesShort : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									monthNames : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									dateFormat : "yymmdd",
									minDate : new Date('2020-01-01'),
									maxDate : new Date('2020-12-31'),
									showMonthAfterYear : true,
								});

			});
</script>


<script type="text/javascript">
	function schedule(ele) {

		var $ele = $(ele);
		var $schedule2 = $('input[name=schedule_2]');

		if ($ele.val() == "0") {
			$schedule2.attr('readonly', false);
			$schedule2.val('');
		} else {
			$schedule2.attr('readonly', true);
			$schedule2.val($ele.val());
		}
		date.submit();
	}
</script>

<style>
.ui-datepicker {
	font-size: 12px;
	width: 190px;
}

.ui-datepicker select.ui-datepicker-month {
	width: 40%;
	font-size: 11px;
}

.ui-datepicker select.ui-datepicker-year {
	width: 60%;
	font-size: 11px;
}
</style>