<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link href="../css/turkey_style.css?ver=71" rel="stylesheet">

<title>Turkey University</title>

	<c:if test="${pro_vo != null}">

		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<div class="header_adm">
				<a href="/Turkey/main"><img src="../img/turkey_adm.png"></a>
				<div class="univ_name"><a href="/Turkey/main">Turkey University</a></div>
				<div class="univ_description"><a href="/Turkey/main">JSL Information Portal System</a></div>
				<div class="univ_logouot"><a href="/Turkey/logout"> [ <b>admin</b> ] 로그아웃</a></div>
			</div>
		</c:if>
		
		<!-- 교수 -->
		<c:if test="${pro_vo.pro_code != '00000'}">
			<div class="header_pro">
				<a href="/Turkey/main"><img src="../img/turkey_pro.png"></a>
				<div class="univ_name"><a href="/Turkey/main">Turkey University</a></div>
				<div class="univ_description"><a href="/Turkey/main">JSL Information Portal System</a></div>
				<div class="univ_logouot"><a href="/Turkey/logout"> [ <b>교수님 </b> ] 로그아웃</a></div>
			</div>
		</c:if>
		
	</c:if>
	
	<!-- 학생 -->
	<c:if test="${stu_vo != null}">
		<div class="header_stu">
			<a href="/Turkey/main"><img src="../img/turkey_stu.png"></a>
			<div class="univ_name"><a href="/Turkey/main">Turkey University</a></div>
			<div class="univ_description"><a href="/Turkey/main">JSL Information Portal System</a></div>
			<div class="univ_logouot"><a href="/Turkey/logout">로그아웃</a></div>
		</div>
	</c:if>