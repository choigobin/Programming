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
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/subject_list">과목 리스트</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/subject2_list">개설된 과목 조회</a>
			</div>

		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_third">
					<form name="sub2_insert" method="post" action="subject2_insert">
						<table style="padding-top:90px;">
							<tr>
								<th>과목코드
								<td>
									<input type="text" name="sub_code" value="${sub_vo.sub_code}" readonly>
								</td>
								<th>과목이름
								<td>
									<input type="text" name="sub_name" value="${sub_vo.sub_name}" readonly>
								</td>
							</tr>
							<tr>
								<th>이수학점
								<td>
									<input type="text" name="sub_credit" value="${sub_vo.sub_credit}" readonly>
								</td>
								<th>담당교수 학번
								<td>
									<input type="text" name="pro_code">
								</td>
							</tr>
							<tr>
								<th>요일 / 교시A
								<td>
									<input type="text" name="time_a">
								</td>
								<th>요일 / 교시B
								<td>
									<input type="text" name="time_b">
								</td>
							</tr>
							<tr>
								<th>학과코드
								<td>
									<input type="text" name="major_code" value="${sub_vo.major_code}" readonly>
								</td>
								<th>정원
								<td>
									<input type="text" name="max_inwon">
								</td>
							</tr>
							<tr>
								<th>학기
								<td>
									<input type="text" name="semester">
								</td>
								<th>수강년도
								<td>
									<input type="text" name="year">
								</td>
							</tr>
							<tr>
								<th>수업구분
								<td>
									<input type="text" name="gubun">
								</td>
								<td colspan="2" style="text-align:right;">
									<input type="button" value="등록" onclick="send()"  style="width:160px; height:38px; margin-right:22px;">
								</td>
							</tr>
						</table>		
						
						
						
					</form>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function send() {
		sub2_insert.submit();
	}
</script>