<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<script>
	function modi() {

		if (stu.tel_2.value == "") {
			alert("핸드폰 번호가 입력되지 않았습니다.");
			stu.tel_2.focus();
			return;
		}
		var tel_2 = stu.tel_2.value.length;
		if (stu.tel_1.value == '011') {
			if (tel_2 != 3) {
				alert("3자리가 아닙니다.");
				stu.tel_2.focus();
				return;
			}
		} else if (stu.tel_1.value == '010') {
			if (tel_2 != 4) {
				alert("4자리가 아닙니다.");
				stu.tel_2.focus();
				return;
			}
		}
		if (stu.tel_3.value == "") {
			alert("핸드폰 번호가 입력되지 않았습니다.");
			stu.tel_3.focus();
			return;
		}
		var tel_3 = stu.tel_3.value.length;
		if (tel_3 != 4) {
			alert("4자리가 아닙니다.");
			stu.tel_3.focus();
			return;
		}

		if (stu.stu_zip.value == "") {
			alert("주소가 입력되지 않았습니다.");
			stu.stu_zip.focus();
			return;
		}
		if (stu.stu_addr.value == "") {
			alert("주소가 입력되지 않았습니다.");
			stu.stu_addr.focus();
			return;
		}

		if (stu.email_1.value == "") {
			alert("E-mail이 입력되지 않았습니다.");
			stu.email_1.focus();
			return;
		}
		if (stu.email_2.value == "") {
			alert("E-mail이 입력되지 않았습니다.");
			stu.email_2.focus();
			return;
		}
		alert("수정되었습니다.")
		stu.submit();
	}

	function pass() {
		location.href = "student_modify";
	}

	function post_check() {
		window.open("post_check", "post_check_form", "width=510 height=540");
	}

	function selectEmail(ele) {

		var $ele = $(ele);
		var $email2 = $('input[name=email_2]');

		if ($ele.val() == "0") {
			$email2.attr('readonly', false);
			$email2.val('');
		} else {
			$email2.attr('readonly', true);
			$email2.val($ele.val());
		}
	}

	$(document).ready(function() {
		$("input[name=email_1]").keyup(function(event) {
			if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
			}
		});
	});
	$(document).ready(function() {
		$("input[name=email_2]").keyup(function(event) {
			if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
			}
		});
	});
</script>



<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_stu">
		<ul>
			<li style="background-color: #FFF;"><a href="/Turkey/student_view" style="color: #2F5597;">정보 조회</a></li>
			<li><a href="/Turkey/student_score">성적 조회</a></li>
			<li><a href="/Turkey/student_sub_cal">시간표 조회</a></li>
			<li><a href="/Turkey/student_attendance">출결 조회</a></li>
			<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			<li><a href="/Turkey/student_apply">수강신청</a></li>
		</ul>
	</div>

	<form name=stu method=post action="student_view" enctype="multipart/form-data">
		<div class="contents">
			<div class="contents_inform_view_stu">
				<div class="contents_inform_view_detail">
					<div class="adm_manage_contents_main_detail_first">
					<div class="adm_manage_contents_main_detail_first_img">
							<div class="select_img">
								<img src="${stu_vo.stu_img}" style="height: 170px; width: 135px;">
							</div>
							<label for="gdsImg">학생 사진</label>
						</div>
						<div class="adm_manage_contents_main_detail_first_inform">
							<div class="adm_manage_contents_main_detail_first_inform_in">
								<table>
									<tr>
										<th>학번</th>
										<td><input type="text" name="stu_code"
											value="${stu_vo.stu_code}" readonly></td>
									</tr>
									<tr>
										<th>성명(한글)</th>
										<td><input type="text" name="stu_name"
											value="${stu_vo.stu_name}" readonly></td>
									</tr>
									<tr>
										<th>생년월일</th>
										<td><input type="text" name="stu_birth"
											value="${stu_vo.stu_birth}" readonly></td>
									</tr>
									<tr>
										<th>성별</th>
										<td><input type="text" name="stu_gender"
											value=<c:choose>
													<c:when test="${(stu_vo.stu_sex eq 0)}">남자</c:when>
													<c:when test="${(stu_vo.stu_sex eq 1)}">여자</c:when>
											  </c:choose>
											readonly></td>
									</tr>
								</table>
							</div>
						</div>
						<div class="adm_manage_contents_main_detail_first_inform">
							<div class="adm_manage_contents_main_detail_first_inform_in">
								<table>
									<tr>
										<th>학과</th>
										<td><input type="text" name="major_name"
											value="${stu_vo.major_name}" readonly></td>
									</tr>
									<tr>
										<th>성명(영어)</th>
										<td><input type="text" name="stu_eng"
											value="${stu_vo.stu_eng}" readonly></td>
									</tr>
									<tr>
										<th>국적</th>
										<td><input type="text" name="stu_nt"
											value=<c:choose>
													<c:when test="${(stu_vo.stu_nt eq 82)}">한국</c:when>
													<c:when test="${(stu_vo.stu_nt eq 81)}">일본</c:when>
													<c:when test="${(stu_vo.stu_nt eq 86)}">중국</c:when>
													<c:when test="${(stu_vo.stu_nt eq 1)}">미국</c:when>
											  </c:choose>
											readonly></td>
									</tr>
									<tr>
										<th>학년</th>
		                              <td><input type="text" name="stu_level"
		                                 value=
		                                 <c:if test="${(stu_vo.stu_level eq 1)}">1학년</c:if>
		                                 <c:if test="${(stu_vo.stu_level eq 2)}">2학년</c:if>
		                                 <c:if test="${(stu_vo.stu_level eq 3)}">3학년</c:if>
		                                 <c:if test="${(stu_vo.stu_level eq 4)}">4학년</c:if>
		                                 readonly></td>
		                           </tr>
									<tr>
										<th>학적상태</th>
										<td><input type="text" name="stu_condition"
											value=<c:choose>
													<c:when test="${(stu_vo.stu_condition eq 1)}">재학</c:when>
													<c:when test="${(stu_vo.stu_condition eq 2)}">휴학</c:when>
													<c:when test="${(stu_vo.stu_condition eq 3)}">졸업</c:when>
											  </c:choose>
											readonly></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<div class="adm_manage_contents_main_detail_second">
						<div class="adm_manage_contents_main_detail_second_contact">
							<table>
								<tr>
									<th>* 학생 주소</th>
								</tr>
								<tr>
									<th>우편번호</th>
									<td>
										<input type="text" name="stu_zip" value="${stu_vo.stu_zip}">&nbsp; 
										<a href="#" onClick="post_check()">
											<img src="../../resources/img/search_stu.png">
										</a>
									</td>
									<th>상세주소</th>
									<td>
										<input type="text" name="stu_addr" style="width: 260px;" value="${stu_vo.stu_addr}">
									</td>
								</tr>
								<tr>
								<th>* 학생 연락처</th>
							</tr>
							<tr>
									<th>전화번호</th>
									<td><c:set var="phone" value="${stu_vo.stu_phone}" /> <select
										name="tel_1">
											<option value="010"
												<c:if test="${fn:substring(phone,0,3) == '010'}">selected</c:if>>010

											
											<option value="011"
												<c:if test="${fn:substring(phone,0,3) == '011'}">selected</c:if>>011

											
									</select><b> - </b> <input type="text" name="tel_2" maxlength="4"
										value="${fn:substring(phone,4,8)}"
										onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
										<b> - </b> <input type="text" name="tel_3" maxlength="4"
										value="${fn:substring(phone,9,13)}"
										onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
									</td>
								</tr>
								<tr>
									<th>이메일</th>
									<td>&nbsp;&nbsp;&nbsp; <input type="text" name="email_1"
										style="width: 130px;"
										value="${fn:substringBefore(stu_vo.stu_email,'@')}"> <b>
											@ </b> <input type="text" name="email_2" style="width: 130px;"
										value="${fn:substringAfter(stu_vo.stu_email,'@')}"> <select
										name="email_3" style="width: 130px;"
										onChange="selectEmail(this)">
											<option value="0">직접입력
											<option value="naver.com">naver.com
											<option value="daum.net">daum.net
											<option value="gmail.com">gmail.com
									</select>
									</td>
								</tr>
							</table>
						</div>

						<div class="stu_manage_contents_main_detail_send">
							<table>
								<tr>
									<td>
										<input type="button" value="학생정보 변경" onclick="modi()">
									</td>
									<td>
										<input type="button" value="비밀번호 변경" onclick="pass()">
									</td>
								</tr>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
	<%@ include file="../include/footer.jsp"%>
</div>