<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<div class="all">

	<%@ include file="../include/header.jsp"%>
	
	<div class="navigation_pro">
		<div class="navi">
			<ul>
				<li><a href="/Turkey/pro_view">정보 조회</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/pro_class" style="color: #CC3D3D;">강의 관리</a></li>
				<li><a href="/Turkey/pro_student">학생 관리</a></li>
				<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			</ul>
		</div>
	</div>
	
	<div class="contents">
			<div class="contents_inform_view">
				<div class="contents_inform_view_detail">
				<div class="pro_detail_forth">
					<div class="adm_contents_in">
						<input type="hidden" name="majorcode" value="${sub.major_code}">
						<input type="hidden" name="subcode" value="${sub.sub_code}">
						<table style="margin-top:35px;">
							<tr>
								<th>개설 년도</th>
								<td>${sub.year}</td>
								<th>개설 학기</th>
								<td>${sub.semester}</td>
								<th>강의 코드</th>
								<td>${sub.major_code}-${sub.sub_code}</td>
								<th>강의명</th>
								<td style="border-right:none;">${sub.sub_name}</td>
							</tr>
						</table>
						<table style="border-top:none;">
							<colgroup>
								<col width="200px;">
								<col width="200px;">
								<col width="200px;">
								<col width="200px;">
								<col width="200px;">
								<col width="200px;">
							</colgroup>
							<tr>
								<th>학번</th>
								<th>이름</th>
								<th>중간점수</th>
								<th>기말점수</th>
								<th>학점</th>
								<th style="border-right:none;">확인</th>
							</tr>
							<c:forEach var="stu" items="${list }">
								<tr>
									<td>${stu.stu_code }</td>
									<td>${stu.stu_name }</td>
									<td><input type="text" size="1" name="${stu.stu_code}m" value="${stu.list_mid }" style="border: 0.5px;"></td>
									<td><input type="text" size="1" name="${stu.stu_code}l" value="${stu.list_last }" style="border: 0.5px;"></td>
									<td><input type="text" size="1" name="${stu.stu_code}s" value="${stu.list_score }" style="border: 0.5px;"></td>
									<td style="border-right:none;"><input type="button" value="확인" onclick="gradeCheck('${stu.stu_code}','${stu.isu}');"></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--**********************************************************************************************************-->
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
function gradeCheck(stucode,isu){
	var obj = new Object();
	obj.stu_code = stucode;
	obj.isu = isu;
	obj.year = ${sub.year};
	obj.semester = ${sub.semester};
	obj.major_code = $('input[name=majorcode]').val();
	obj.sub_code = $('input[name=subcode]').val();
	obj.list_mid = $('input[name='+stucode+'m]').val();
	obj.list_last = $('input[name='+stucode+'l]').val();
	obj.list_score = $('input[name='+stucode+'s]').val();
	obj.sub_credit = ${list[0].sub_credit};
	$.ajax({
		url: "proStuGrade",
		type: "POST",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(obj),
		success: function(data){        
		}
	}) 
};
</script>
