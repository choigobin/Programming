<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${pro_vo != null}">

	<!-- 관리자 -->
	<c:if test="${pro_vo.pro_code == '00000'}">
		<div class="footer_adm">
			<div class="copyright">
				34856 대전 중구 용두동 35-17 희영빌딩 701호 <br> Copyright (C)
				2020 Turkey University. All Rights Reserved.
			</div>
		</div>
	</c:if>
		
	<!-- 교수 -->
	<c:if test="${pro_vo.pro_code != '00000'}">
		<div class="footer_pro">
			<div class="copyright">
				34856 대전 중구 용두동 35-17 희영빌딩 701호 <br> Copyright (C)
				2020 Turkey University. All Rights Reserved.
			</div>
		</div>
	</c:if>
		
</c:if>
	
<!-- 학생 -->
<c:if test="${stu_vo != null}">
	<div class="footer_stu">
		<div class="copyright">
			34856 대전 중구 용두동 35-17 희영빌딩 701호 <br> Copyright (C)
			2020 Turkey University. All Rights Reserved.
		</div>
	</div>
</c:if>