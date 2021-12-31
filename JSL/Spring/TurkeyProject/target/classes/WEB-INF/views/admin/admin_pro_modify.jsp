<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_adm">
		<div class="navi">
			<ul>
				<li><a href="admin_stu_view">학생 관리</a></li>
				<li style="background-color: #FFF;">
					<a href="admin_pro_view" style="color: #598700;">교수 관리</a></li>
				<li><a href="/Turkey/major_insert">학과 관리</a></li>
				<li><a href="/Turkey/subject_insert">과목 관리</a></li>
				<li><a href="/Turkey/illjung_insert">>일정 관리</a></li>
			</ul>
		</div>
	</div>
	
	<div class="adm_manage_contents">
		<div class="adm_manage_contents_cate">
			<div class="adm_manage_contents_cate_menu_select">
				<a href="admin_pro_view">교수 정보 조회</a>
			</div>
			<div class="adm_manage_contents_cate_menu">
				<a href="admin_pro_insert">교수 정보 등록</a>
			</div>
		</div>
		
		
		
		<form name="pro" method="post" action="admin_pro_modi" enctype="multipart/form-data">
			<div class="adm_manage_contents_main">
				<div class="adm_manage_contents_main_detail">
					<div class="adm_manage_contents_main_detail_first">
						<div class="adm_manage_contents_main_detail_first_img">
							<div class="select_img">
								<img src="${pro.pro_img}" style="height: 170px; width: 135px;"/>
								<input type="file" id="gdsImg" name="filename"  />
								<input type="hidden" name="filename_2"/>
							</div>
							<script>
								$("#gdsImg").change(function(){
								if(this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data) {
								$(".select_img img").attr("src", data.target.result).width(150);        
								}
								reader.readAsDataURL(this.files[0]);
								}
								});
							</script>
								 			
							<label for="gdsImg">교수 사진</label>
							
						</div>
						<div class="adm_manage_contents_main_detail_first_inform">
							<div class="adm_manage_contents_main_detail_first_inform_in">
								<table>
									<tr>
										<th>학번</th>
										<td><input type="text" name="pro_code" maxlength="5" value="${pro.pro_code}" readonly></td>
									</tr>
									<tr>
										<th>성명(한글)</th>
										<td>
											<input type="text" name="pro_name" value="${pro.pro_name}">
										</td>
									</tr>
									<tr>
										<th>생년월일</th>
										<td>
											<input type="text" name="pro_birth" id="Date" value="${pro.pro_birth}"  readonly style="width:154px;">
										</td>
									</tr>
										<tr>
										<th>성별</th>
										<td>
											<input type="radio" name="pro_sex" value="0" ${man}>남자
											<input type="radio" name="pro_sex" value="1" ${woman} >여자
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
										<td>
											<select name="major_code">
												<c:forEach items="${list}" var = "MajorVO">
													<option value="${MajorVO.major_code}"<c:if test="${pro.major_code == MajorVO.major_code}">selected</c:if>>${MajorVO.major_name}학과
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th>성명(영어)</th>
										<td>
											<input type="text" name="pro_eng" value="${pro.pro_eng}">
										</td>
									</tr>
									<tr>
										<th>국적</th>
										<td>
											<select name="pro_nt">
												<option value="82" <c:if test="${pro.pro_nt == 82}">selected</c:if>>한국
												<option value="81" <c:if test="${pro.pro_nt == 81}">selected</c:if>>일본
												<option value="86" <c:if test="${pro.pro_nt == 86}">selected</c:if>>중국
												<option value="1"  <c:if test="${pro.pro_nt == 1}">selected</c:if>>미국
											</select>
										</td>
									</tr>
									<tr>
									<th>권한등급</th>
									<td>
										<select name="pro_grade">
											<option value="1" <c:if test="${pro.pro_grade == 1}">selected</c:if>>기본
											<option value="2" <c:if test="${pro.pro_grade == 2}">selected</c:if>>학과장
										</select>
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
							
						<div class="adm_manage_contents_main_detail_send">
							<input type="button" value="수정" onclick="modi()">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function post_check() {
		window.open("admin_stu_insert_post.jsp", "admin_stu_insert_post",
		"width=510 height=540");		
	}
	function modi()
	{


		if(pro.pro_name.value=="")
		{
			alert("이름이 입력되지 않았습니다.");
			pro.pro_name.focus();
			return;
		}

		if(pro.pro_eng.value=="")
		{
			alert("영문 이름이 입력되지 않았습니다.");
			pro.pro_eng.focus();
			return;
		}
				
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
		
		alert("수정합니다");
	   	pro.submit();
	}
</script>

<script type="text/javascript">
    $(document).ready(function () {
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            $( "#Date" ).datepicker({   
            	showOn: "both", 
            	buttonImage: "../../resources/img/calender_adm.png",
                buttonImageOnly: "true",
                 changeMonth: true,
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yymmdd",
                 maxDate: 0
           }); 
            $("img.ui-datepicker-trigger").attr("style", "height:28px; width:28px; margin-left:6px; vertical-align:middle; cursor:pointer;"); 
	});
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
</script>