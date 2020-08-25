<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_adm">
		<div class="navi">
			<ul>
				<li style="background-color: #FFF;"><a href="/Turkey/admin_stu_view" style="color: #598700;">학생 관리</a></li>
				<li><a href="/Turkey/admin_pro_view">교수 관리</a></li>
				<li><a href="/Turkey/major_insert">학과 관리</a></li>
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li><a href="/Turkey/illjung_insert">일정 관리</a></li>
			</ul>
		</div>
	</div>

	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu_select">
				<a href="admin_stu_view">학생 정보 조회</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="admin_stu_insert">학생 정보 등록</a>
			</div>
		</div>

		<form name="student" method="post" action="admin_stu_view2" enctype="multipart/form-data">
			<div class="adm_manage_contents_main">
				<div class="adm_manage_contents_main_detail">
					<div class="adm_manage_contents_main_detail_search" >
						<select name="major">
							<option value="0" <c:if test="${map.major == '0'}">selected</c:if> >학과 전체
							<c:forEach items="${list}" var = "MajorVO">
								<option value="${MajorVO.major_code}" <c:if test="${MajorVO.major_code == map.major}">selected</c:if> >${MajorVO.major_name}학과
							</c:forEach>
						</select>
						<select name="grade">
							<option value="0" <c:if test="${map.grade == '0'}">selected</c:if> >학년 전체
							<option value="1" <c:if test="${map.grade == '1'}">selected</c:if> >1학년
							<option value="2" <c:if test="${map.grade == '2'}">selected</c:if> >2학년
							<option value="3" <c:if test="${map.grade == '3'}">selected</c:if> >3학년
							<option value="4" <c:if test="${map.grade == '4'}">selected</c:if> >4학년
						</select>
						<select name="condition">
							<option value="0" <c:if test="${map.condition == '0'}">selected</c:if> >재적 전체
							<option value="1" <c:if test="${map.condition == '1'}">selected</c:if> >재학
							<option value="2" <c:if test="${map.condition == '2'}">selected</c:if> >휴학
							<option value="3" <c:if test="${map.condition == '3'}">selected</c:if> >졸업
						</select>
						<input type="button" value="조회" onclick="search()">
					</div>
					<div class="adm_manage_contents_main_detail_cate">
						<table>
							<tr>
								<th>학번</th>
								<th>이름</th>
								<th>학과</th>
								<th>학년</th>
								<th style="border-right: none;">학적상태</th>
							</tr>
						</table>
					</div>
					<div class="adm_manage_contents_main_detail_result">				
						<table>
							<c:forEach items="${list1}" var = "StudentVO">
								<c:choose>
									<c:when test="${(map.major == '0')}">  
										<c:choose>
											<c:when test="${(map.grade == '0')}">
												<c:choose>
													<c:when test="${(map.condition == '0')}"> <!-- 8. 전 전 전 -->
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>							
													</c:when>
													<c:when test="${(StudentVO.stu_condition == map.condition)}"> <!-- 7. 전 전 선 -->
														<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
														<tr>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>
													</c:when>
												</c:choose>
											</c:when>
											<c:when test="${(StudentVO.stu_level == map.grade)}"> 
												<c:choose>
													<c:when test="${(map.condition == '0')}"> <!-- 6. 전 선 전 --> 
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>
													</c:when>
													<c:when test="${(StudentVO.stu_condition == map.condition)}"> <!-- 4. 전 선 선 -->
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>
													</c:when>
												</c:choose>								
											</c:when>
										</c:choose>
									</c:when>
									<c:when test="${(StudentVO.major_code == map.major)}"> 
										<c:choose>
											<c:when test="${(map.grade == '0')}">  
												<c:choose>
													<c:when test="${(map.condition == '0')}"> <!-- 5. 선 전 전 --> 
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>
													</c:when>
													<c:when test="${(StudentVO.stu_condition == map.condition)}"> <!-- 3. 선 전 선 -->  
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>
													</c:when>
												</c:choose>
											</c:when>
											<c:when test="${(StudentVO.stu_level == map.grade)}"> 
												<c:choose>
													<c:when test="${(map.condition == '0')}">   <!-- 2. 선 선 전 --> 
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>	
														</tr>						
													</c:when>
													<c:when test="${(StudentVO.stu_condition == map.condition)}"> <!-- 1. 선 선 선 --> 
														<tr>
															<td><a href="admin_stu_modi?stu_code=${StudentVO.stu_code}">${StudentVO.stu_code}</a></td>
															<td>${StudentVO.stu_name}</td>
															<td>${StudentVO.major_name}</td>							
															<td>${StudentVO.stu_level}학년</td>
															<td style="border-right: none;">
																<c:choose>
																	<c:when test="${(StudentVO.stu_condition eq '1')}">재학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '2')}">휴학</c:when>
																	<c:when test="${(StudentVO.stu_condition eq '3')}">졸업</c:when>
																</c:choose>
															</td>
														</tr>
													</c:when>
												</c:choose>								
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>																
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function search() {
	   	student.submit();
	}	
</script>