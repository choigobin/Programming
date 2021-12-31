<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<script>
	function modi() {
		
		if(pro.tel_2.value=="")
		{
			alert("핸드폰 번호가 입력되지 않았습니다.");
			pro.tel_2.focus();
			return;
		}
		var tel_2 = pro.tel_2.value.length;
		if(pro.tel_1.value=='011')
		{
			if(tel_2!=3)
			{
				alert("3자리가 아닙니다.");
				pro.tel_2.focus();
				return;
			}	
		}
		else if(pro.tel_1.value=='010')
		{
			if(tel_2!=4)
			{
				alert("4자리가 아닙니다.");
				pro.tel_2.focus();
				return;
			}
		}
		if(pro.tel_3.value=="")
		{
			alert("핸드폰 번호가 입력되지 않았습니다.");
			pro.tel_3.focus();
			return;
		}
		var tel_3 = pro.tel_3.value.length;
		if(tel_3!=4)
		{
			alert("4자리가 아닙니다.");
			pro.tel_3.focus();
			return;
		}
		
		if(pro.email_1.value=="")
		{
			alert("E-mail이 입력되지 않았습니다.");
			pro.email_1.focus();
			return;
		}
		if(pro.email_2.value=="")
		{
			alert("E-mail이 입력되지 않았습니다.");
			pro.email_2.focus();
			return;
		}
		
		alert("수정 되었습니다.");
		pro.submit();
	}

	function pass() {
		location.href = "pro_pass";
	}

	
	function selectEmail(ele){
    	
    	var $ele = $(ele);
    	var $email2 = $('input[name=email_2]');
    	
    	if($ele.val() == "0")
    	{
    		$email2.attr('readonly', false); $email2.val('');
    	}
    	else
    	{
    		$email2.attr('readonly', true); $email2.val($ele.val());
    	}
    }
		
	$(document).ready(function(){
  	  $("input[name=email_1]").keyup(function(event){ 
  	   if (!(event.keyCode >=37 && event.keyCode<=40)) {
  	    var inputVal = $(this).val();
  	    $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
  	   }
  	  });
  	});
  $(document).ready(function(){
	  $("input[name=email_2]").keyup(function(event){ 
	   if (!(event.keyCode >=37 && event.keyCode<=40)) {
	    var inputVal = $(this).val();
	    $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
	   }
	  });
	});
	
</script>


<div class="all">

	<%@ include file="../include/header.jsp"%>
	
	<div class="navigation_pro">
		<div class="navi">
			<ul>
				<li style="background-color: #FFF;"><a href="/Turkey/pro_view" style="color: #CC3D3D;">정보 조회</a></li>
				<li><a href="/Turkey/pro_class">강의 관리</a></li>
				<li><a href="/Turkey/pro_student">학생 관리</a></li>
				<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			</ul>
		</div>
	</div>

	<form name=pro method=post action="pro_view" enctype="multipart/form-data">
		<div class="contents">
			<div class="contents_inform_view">
				<div class="contents_inform_view_detail">
					<div class="adm_manage_contents_main_detail_first">
					<div class="adm_manage_contents_main_detail_first_img">
						<div class="select_img">
								<img src="${pro.pro_img}" style="height: 170px; width: 135px;">
							</div>
							<label for="gdsImg">교수 사진</label>
						</div>
						<div class="adm_manage_contents_main_detail_first_inform">
							<div class="adm_manage_contents_main_detail_first_inform_in">
								<table>
									<tr>
										<th>교수 번호</th>
										<td><input type="text" name="pro_code"
											value="${pro.pro_code}" readonly></td>
									</tr>
									<tr>
										<th>성명(한글)</th>
										<td><input type="text" name="pro_name"
											value="${pro.pro_name}" readonly></td>
									</tr>
									<tr>
										<th>생년월일</th>
										<td><input type="text" name="pro_birth"
											value="${pro.pro_birth}" readonly></td>
									</tr>
									<tr>
										<th>성별</th>
										<td><input type="text" name="pro_sex"
										value=<c:choose>
													<c:when test="${(pro.pro_sex eq 0)}">남자</c:when>
													<c:when test="${(pro.pro_sex eq 1)}">여자</c:when>
											  </c:choose>readonly>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="adm_manage_contents_main_detail_first_inform">
							<div class="adm_manage_contents_main_detail_first_inform_in">
								<table>
									<tr>
										<th>학과</th>
										<td><input type="text" name="major_name"
											value="${pro.major_name}학과" readonly></td>
									</tr>
									<tr>
										<th>성명(영어)</th>
										<td><input type="text" name="stu_eng"
											value="${pro.pro_eng}" readonly></td>
									</tr>
									<tr>
										<th>국적</th>
										<td><input type="text" name="pro_nt"
											value=<c:choose>
														<c:when test="${(pro.pro_nt eq 82)}">한국</c:when>
														<c:when test="${(pro.pro_nt eq 81)}">일본</c:when>
														<c:when test="${(pro.pro_nt eq 86)}">중국</c:when>
														<c:when test="${(pro.pro_nt eq 1)}">미국</c:when>
												  </c:choose>readonly>			
										</td>
									</tr>
									<tr>
										<th>권한</th>
										<td><input type="text" name="pro_grade"
											value=<c:choose>
														<c:when test="${(pro.pro_grade eq 1)}">기본</c:when>
														<c:when test="${(pro.pro_grade eq 2)}">학과장</c:when>
												  </c:choose>readonly>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<div class="adm_manage_contents_main_detail_second">
						<div class="adm_manage_contents_main_detail_second_contact">
							<table>
								<tr>
									<th>* 교수 연락처</th>
								</tr>
								<tr>
									<th>전화번호</th>
									<td>
										<c:set var="phone" value="${pro.pro_phone}"/>
										<select name="tel_1">
											<option value="010" <c:if test="${fn:substring(phone,0,3) == '010'}">selected</c:if>>010
											<option value="011" <c:if test="${fn:substring(phone,0,3) == '011'}">selected</c:if>>011
										</select><b> - </b>
										<input type="text" name="tel_2" maxlength="4" value="${fn:substring(phone,4,8)}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">			
										<b> - </b>
										<input type="text" name="tel_3" maxlength="4" value="${fn:substring(phone,9,13)}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
									</td>
								</tr>
								<tr>
									<th>이메일</th>
									<td>&nbsp;&nbsp;&nbsp;
										<input type="text" name="email_1" style="width:130px;" value="${fn:substringBefore(pro.pro_email,'@')}">
										<b> @ </b>
										<input type="text" name="email_2" style="width:130px;" value="${fn:substringAfter(pro.pro_email,'@')}">
										<select name="email_3" style="width:130px;" onChange="selectEmail(this)">
											<option value="0">직접입력
											<option value="naver.com">naver.com
											<option value="daum.net">daum.net
											<option value="gmail.com">gmail.com
										</select>
									</td>
								</tr>
							</table>					
						</div>
						<div class="pro_manage_contents_main_detail_send" style="float:right;">
							<table>
								<tr>
									<td>
										<input type="button" value="교수정보 변경" onclick="modi()">
									</td>
									<td>
										<input type="button" value="비밀번호 변경" onclick="pass()">
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<%@ include file="../include/footer.jsp"%>
</div>