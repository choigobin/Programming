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
				<div class="adm_manage_contents_main_detail_search">
					<form name="sub_list" method="post" action="subject_list">
						<select name="major_code">
							<option value="">개설학과선택</option>
								<c:forEach var="major" items="${major_list}">
									<option value="${major.major_code}">
										${major.major_name}
									</option>
								</c:forEach>
						</select>
						<input type="button" value="검색" onclick="send()" style="width:100px;">
					</form>
				</div>
				<div class="adm_manage_contents_main_detail_forth">
					<table>
						<tr>
							<th>과목 코드</th>
							<th>과목명</th>
							<th style="border-right: none;">학과 코드</th>
						</tr>
					</table>
				</div>
				<div class="adm_manage_contents_main_detail_fifth">				
					<table>
						<c:if test="${empty sub_list}">
							<tr>
								<td style="border-right: none;">개설된 과목이 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${!empty sub_list}">
							<c:forEach var="sub" items="${sub_list}">
								<tr>
									<td>${sub.sub_code}</td>
									<td><a href="/Turkey/subject2_insert?sub_code=${sub.sub_code}&major_code=${sub.major_code}">${sub.sub_name}</a></td>
									<td style="border-right: none;">${sub.major_code}</td>
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
		if(sub_list.major_code.value == ""){
			alert("개설 학과를 입력 해주세요");
			sub_list.major_code.focus();
			return;
		}

		sub_list.submit();
	}
	
	function touroku(){
		
	}
</script>