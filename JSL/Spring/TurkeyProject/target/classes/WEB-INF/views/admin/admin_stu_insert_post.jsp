<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/turkey_style.css?ver=6" rel="stylesheet">

<title>Turkey University</title>

	<div class="post_check" onresize="parent.resizeTo(500,500)" onload="parent.resizeTo(500,400)">
	
		<c:if test="${pro_vo != null}">
		
		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<div class="post_check_adm_miniheader">
				<img src="../img/turkey_adm.png">
				<div class="post_check_adm_miniheader_name">Turkey University</div>
				<div class="post_check_adm_miniheader_description">JSL Information Portal System</div>
			</div>
		
			<div class="post_check_adm_miniheader_search_name">
				우편 번호 검색
				<img src="../img/search_adm.png">
			</div>
		
			<div class="post_check_adm_miniheader_search_form">
				<form name="post_check_form" method="post" action="post_check">
					<input type="text" name="addr" placeholder="동 이름">
					<input type="button" value="조회" onclick="check()"><br><br>
				</form>
				
				<form>
					<div class="post_check_adm_miniheader_search_form_result">
					<c:forEach var="postList" items="${post_list}">
						<a href="javascript:sendAddr('${postList.zipcode}','${postList.sido}','${postList.gugun}','${postList.dong}',' ${postList.bunji}')"> 
								${postList.zipcode} &nbsp; ${postList.sido} &nbsp; ${postList.gugun} &nbsp; ${postList.dong} &nbsp; ${postList.bunji}
						</a>
						<br>
					</c:forEach>
					</div>
				</form>
			</div>
		</c:if>
		
		<!-- 교수 -->
		<c:if test="${pro_vo.pro_code != '00000'}">
			<div class="post_check_adm_miniheader">
				<img src="../img/turkey_adm.png">
				<div class="post_check_adm_miniheader_name">Turkey University</div>
				<div class="post_check_adm_miniheader_description">JSL Information Portal System</div>
			</div>
		
			<div class="post_check_name">
				우편 번호 검색
				<img src="../img/search.png">
			</div>
		
			<div class="post_check_form">
				<form name="post_check_form" method="post" action="post_check">
					<input type="text" name="addr" placeholder="동 이름">
					<input type="button" value="조회" onclick="check()"><br><br>
				</form>
				<form>
					<div class="post_check_form_search">
					<c:forEach var="postList" items="${post_list}">
						<a href="javascript:sendAddr('${postList.zipcode}','${postList.sido}','${postList.gugun}','${postList.dong}',' ${postList.bunji}')"> 
								${postList.zipcode} &nbsp; ${postList.sido} &nbsp; ${postList.gugun} &nbsp; ${postList.dong} &nbsp; ${postList.bunji}
						</a>
						<br>
					</c:forEach>
					</div>
				</form>
			</div>
		</c:if>
		
	</c:if>
	
	<!-- 학생 -->
	<c:if test="${stu_vo != null}">
		<div class="post_check_stu_miniheader">
			<img src="../img/turkey_stu.png">
			<div class="post_check_stu_miniheader_name">Turkey University</div>
			<div class="post_check_stu_miniheader_description">JSL Information Portal System</div>
		</div>
		<div class="post_check_stu_miniheader_search_name">
			우편 번호 검색
			<img src="../img/search_stu.png">
		</div>
		
			<div class="post_check_stu_miniheader_search_form">
				<form name="post_check_form" method="post" action="post_check">
					<input type="text" name="addr" placeholder="동 이름">
					<input type="button" value="조회" onclick="check()" style="width:90px;"><br><br>
				</form>
				<form>
				<div class="post_check_adm_miniheader_search_form_result">
				<c:forEach var="postList" items="${post_list}">
					<a href="javascript:sendAddr('${postList.zipcode}','${postList.sido}','${postList.gugun}','${postList.dong}',' ${postList.bunji}')"> 
							${postList.zipcode} &nbsp; ${postList.sido} &nbsp; ${postList.gugun} &nbsp; ${postList.dong} &nbsp; ${postList.bunji}
					</a>
					<br>
				</c:forEach>
				</div>
			</form>
			</div>
			
	</c:if>
</div>
	
		
	
<script>
	function check(){
		if(post_check_form.addr.value == ""){
			alert("검색할 주소를 입력해 주세요");
			post_check_form.addr.focus();
			return;
		}
		post_check_form.submit();
	}
	
	function sendAddr(zipcode,sido,gugun,dong,bunji){
		var addr = sido + " " + gugun + " " + dong+ " " +bunji;
		opener.stu.stu_zip.value = zipcode;
		opener.stu.stu_addr.value = addr;
		self.close();
	}
	
</script>