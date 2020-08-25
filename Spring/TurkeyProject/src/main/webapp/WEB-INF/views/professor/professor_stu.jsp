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
				<li><a href="/Turkey/pro_class">강의 관리</a></li>
				<li style="background-color: #FFF;"><a href="/Turkey/pro_student" style="color: #CC3D3D;">학생 관리</a></li>
				<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			</ul>
		</div>
	</div>
	
	<div class="contents">
		<div class="contents_inform_view">
			<div class="contents_inform_view_detail">
				<div class="pro_detail_forth">
					<table style="padding-top:35px; border-top:none;">
							<tr>
								<th style="border-top:0.5px solid #8C8C8C;">학번</th>
								<th style="border-top:0.5px solid #8C8C8C;">이름</th>
								<th style="border-top:0.5px solid #8C8C8C;">성별</th>
								<th style="border-top:0.5px solid #8C8C8C;">이메일</th>
								<th style="border-top:0.5px solid #8C8C8C;">전화번호</th>
								<th style="border-top:0.5px solid #8C8C8C; border-right:none;">학적 상태</th>
							</tr>
						</table>
					<div class="adm_contents_in">
							<table>
							<c:forEach var="stu" items="${list}">
                        	<tr>
	                            <td>${stu.stu_code}</td>
	                            <td>${stu.stu_name}</td>
                           		<td><c:if test="${stu.stu_sex eq 0}">남자</c:if> 
                           			<c:if test="${stu.stu_sex eq 1}">여자</c:if>
                           		</td>
	                           <td>${stu.stu_email}</td>
	                           <td>${stu.stu_phone}</td>
	                           <td style="border-right: none;">
	                           <c:if test="${stu.stu_condition == '1'}">재학</c:if> 
	                           <c:if test="${stu.stu_condition == '2'}">휴학</c:if> 
	                           <c:if test="${stu.stu_condition == '3'}">졸업</c:if>
	                           <c:if test="${stu.stu_condition == '4'}">재적</c:if></td>
                        	</tr>
                     		</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>
