<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_adm">
		<div class="navi">
			<ul>
				<li><a href="admin_stu_view">학생 관리</a></li>
				<li><a href="admin_pro_view">교수 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/major_insert" style="color: #598700;">학과 관리</a></li>
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li><a href="/Turkey/illjung_insert">일정 관리</a></li>
			</ul>
		</div>
	</div>

	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/major_insert">학과 등록</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/major_list">학과 리스트</a>
			</div>

		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_third">
					<form name="major_insert" method="post" action="major_insert">
						<table>
							<tr>
								<th>학과 코드</th>
								<td>
									<input type="text" name="major_code">
								</td>
								<th>학과 이름</th>
								<td>
									<input type="text" name="major_name">
								</td>
								<td><input type="button" value="등록" onclick="send()"></td>
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
		if(major_insert.major_code.value==""){
			alert("학과코드 입력 하세요");
			major_insert.major_code.focus();
			return;
		}
		if(major_insert.major_name.value==""){
			alert("학과이름 입력 하세요");
			major_insert.major_name.focus();
			return;
		}
		alert("학과 정보를 등록 합니다.");
		major_insert.submit();
	}
</script>