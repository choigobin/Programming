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
			<div class="adm_manage_contents_cate_menu">
				<a href="admin_stu_view">학생 정보 조회</a>
			</div>
			<div class="adm_manage_contents_cate_menu_select">
				<a href="admin_stu_insert">학생 정보 등록</a>
			</div>
		</div>
		
		
		
	<form name="stu" method="post" action="admin_stu_insert" enctype="multipart/form-data">
		<div class="adm_manage_contents_main">
			<div class="adm_manage_contents_main_detail">
				<div class="adm_manage_contents_main_detail_first">
					<div class="adm_manage_contents_main_detail_first_img">
						<div class="select_img">
							<img src="" />
							<input type="file" id="gdsImg" name="filename"  />
						</div>								
						<script>
							$("#gdsImg").change(function(){
							if(this.files && this.files[0]) {
							var reader = new FileReader;
							reader.onload = function(data) {
							$(".select_img img").attr("src", data.target.result).width(135).height(170);        
							}
							reader.readAsDataURL(this.files[0]);
							}
							});
							$('#myFileInput').attr('title', '');
						</script>
							 			
						<label for="gdsImg">학생 사진</label>
							
					</div>

					<div class="adm_manage_contents_main_detail_first_inform">
						<div class="adm_manage_contents_main_detail_first_inform_in">
							<table>
								<tr>
									<th>학번</th>
									<td><input type="text" name="stu_code" maxlength="8" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></td>
								</tr>
								<tr>
									<th>성명(한글)</th>
									<td><input type="text" name="stu_name"></td>
								</tr>
								<tr>
									<th>생년월일</th>
									<td><input type="text" name="stu_birth" id="Date" readonly style="width:154px;"></td>												
								</tr>
								<tr>
									<th>담당교수번호</th>
									<td><input type="text" name="pro_code" maxlength="5" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></td>
								</tr>
								<tr>
									<th>성별</th>
									<td>
										<input type="radio" name="stu_sex" value="0">남자
										<input type="radio" name="stu_sex" value="1">여자
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
											<option value="0">학과 선택
										<c:forEach items="${list}" var = "MajorVO">
											<option value="${MajorVO.major_code}">${MajorVO.major_name}학과
										</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<th>성명(영어)</th>
									<td><input type="text" name="stu_eng"></td>
								</tr>
								<tr>
									<th>국적</th>
									<td>
										<select name="stu_nt">
											<option value="0">국적 선택
											<option value="82">한국
											<option value="81">일본
											<option value="86">중국
											<option value="1">미국
										</select>
									</td>
								</tr>
								<tr>
									<th>학년</th>
									<td>
										<select name="stu_level">
											<option value="0">학년 선택
											<option value="1">1학년
											<option value="2">2학년
											<option value="3">3학년
											<option value="4">4학년
										</select>
									</td>
								</tr>
								<tr>
									<th>학적</th>
									<td>
										<select name="stu_condition">
											<option value="0">학적 선택
											<option value="1">재학
											<option value="2">휴학
											<option value="3">졸업
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
								<th>* 학생 주소</th>
							</tr>
							<tr>
								<th>우편번호</th>
								<td>
									<input type="text" name="stu_zip">&nbsp;
									<a href="#" onClick="post_check()"><img src="../../resources/img/search_adm.png"></a>
								</td>
								<th>상세주소</th>
								<td>
									<input type="text" name="stu_addr" style="width:260px;">
								</td>
							</tr>
							<tr>
								<th>* 학생 연락처</th>
							</tr>
							<tr>
								<th>전화번호</th>
								<td>
									<select name="tel_1">
										<option value="010">010
										<option value="011">011
									</select><b> - </b>
									<input type="text" name="tel_2" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
									<b> - </b>
									<input type="text" name="tel_3" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>&nbsp;&nbsp;&nbsp;
									<input type="text" name="email_1" style="width:130px;"><b> @ </b>
									<input type="text" name="email_2" style="width:130px;">
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
						<input type="button" value="등록" onclick="insert()">
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
			window.open("post_check", "post_check_form",
			"width=510 height=540");			
		}
	function insert()
	{
		
		if(stu.filename.value=="")
		{
			alert("사진이 선택되지 않았습니다.");
			stu.filename.focus();
			return;
		}		
		if(stu.stu_code.value=="")
		{
			alert("학번이 입력되지 않았습니다.");
			stu.stu_code.focus();
			return;
		}		
		var stu_code = stu.stu_code.value.length;
		if(stu_code!=8)
		{
			alert("8자리가 아닙니다.");
			stu.stu_code.focus();
			return;
		}
		if(stu.stu_name.value=="")
		{
			alert("이름이 입력되지 않았습니다.");
			stu.stu_name.focus();
			return;
		}
		if(stu.stu_birth.value=="")
		{
			alert("생년월일이 선택되지 않았습니다.");
			stu.stu_brith.focus();
			return;
		}
		if(stu.stu_sex.value=="")
		{
			alert("성별이 선택되지 않았습니다.");
			stu.stu_sex.focus();
			return;
		}
		if(stu.major_code.value==0)
		{
			alert("학과가 선택되지 않았습니다.");
			stu.major_code.focus();
			return;
		}
		if(stu.stu_eng.value=="")
		{
			alert("영문 이름이 입력되지 않았습니다.");
			stu.stu_eng.focus();
			return;
		}
		if(stu.stu_nt.value==0)
		{
			alert("국적이 선택되지 않았습니다.");
			stu.stu_nt.focus();
			return;
		}
		if(stu.stu_level.value==0)
		{
			alert("학년이 선택되지 않았습니다.");
			stu.stu_level.focus();
			return;
		}
		if(stu.stu_condition.value==0)
		{
			alert("학적이 선택되지 않았습니다.");
			stu.stu_condition.focus();
			return;
		}
		
		if(stu.pro_code.value=="")
		{
			alert("담당 교수 번호가 입력되지 않았습니다.");
			stu.pro_code.focus();
			return;
		}
		var pro_code = stu.pro_code.value;
		if(pro_code<5)
		{
			alert("5자리가 아닙니다.");
			stu.pro_code.focus();
			return;
		}
		
		if(stu.tel_2.value=="")
		{
			alert("핸드폰 번호가 입력되지 않았습니다.");
			stu.tel_2.focus();
			return;
		}
		var tel_2 = stu.tel_2.value.length;
		if(stu.tel_1.value=='011')
		{
			if(tel_2!=3)
			{
				alert("3자리가 아닙니다.");
				stu.tel_2.focus();
				return;
			}	
		}
		else if(stu.tel_1.value=='010')
		{
			if(tel_2!=4)
			{
				alert("4자리가 아닙니다.");
				stu.tel_2.focus();
				return;
			}
		}
		if(stu.tel_3.value=="")
		{
			alert("핸드폰 번호가 입력되지 않았습니다.");
			stu.tel_3.focus();
			return;
		}
		var tel_3 = stu.tel_3.value.length;
		if(tel_3!=4)
		{
			alert("4자리가 아닙니다.");
			stu.tel_3.focus();
			return;
		}

		if(stu.email_1.value=="")
		{
			alert("E-mail이 입력되지 않았습니다.");
			stu.email_1.focus();
			return;
		}
		if(stu.email_2.value=="")
		{
			alert("E-mail이 입력되지 않았습니다.");
			stu.email_2.focus();
			return;
		}
		
		alert("등록합니다");
	   	stu.submit();
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