<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_adm">
		<div class="navi">
			<ul>
				<li><a href="admin_stu_view">학생 관리</a></li>
				<li><a href="admin_pro_view">교수 관리</a></li>
				<li><a href="/Turkey/major_insert">학과 관리</a></li>
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/illjung_insert" style="color: #598700;">일정 관리</a></li>
			</ul>
		</div>
	</div>

	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu_select">
				<a href="/Turkey/illjung_insert">일정 등록</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="/Turkey/illjung_list">일정 리스트</a>
			</div>
		</div>

		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_third">
					<form name="illjung_insert" method="post" action="illjung_insert">
						<table>
							<tr>
								<th>날짜</th>
								<td>
									<input type="text" name="day">
								</td>
							</tr>
							<tr>
								<th>일정내용</th>
								<td>
									<textarea name="contents" style="width:300px; height:100px; resize:none;"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" value="등록" onclick="send()" style="margin:15px 200px;">
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
		if(illjung_insert.day.value==""){
			alert("날짜를 입력 하세요");
			illjung_insert.day.focus();
			return;
		}
		if(illjung_insert.contents.value==""){
			alert("일정 내용을 입력 하세요");
			illjung_insert.contents.focus();
			return;
		}
		alert("일정 정보를 등록 합니다.");
		illjung_insert.submit();
	}
</script>