<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<div class="pro_detail_search">
						<form name="proClassSearch" method="post">
							<table>
								<tr>
									<th>개설 년도</th>
									<td>
										<select name="year">
											<option value="2019">2019 년
											<option value="2020" selected>2020 년
										</select>
									</td>
									<th>개설 학기</th>
									<td>
										<select name="semester">
											<option value="1">1 학기
											<option value="2">2 학기
										</select>
									</td>
									<td>
										<input type="button" name="classSearch" value="검색">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div class="pro_detail_forth">
						<div class="adm_contents_in" id="result">
						</div>
					</div>
				</div>
			</div>
		</div>
		
	<%@ include file="../include/footer.jsp"%>
</div>
<script>
$("[name='classSearch']").click(function(){
	var obj = new Object();
	obj.year = $("select[name='year']").val();
	obj.semester = $("select[name='semester']").val();
	
	$.ajax({
		url: "pro_classSe",
		type: "POST",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(obj),
		success: function(data){
			output='';
			timeA='';
			timeB='';
			output+= '<table>';
			output+= '<tr><th>과목번호&nbsp;</th><th>과목명&nbsp;&nbsp;</th><th>수업&nbsp;&nbsp;</th><th>수업&nbsp;&nbsp;</th><th>수강인원</th><th style="border-right:none;">성적</th></tr>';
			$.each(data,function(){
				timeA='';
				timeB='';
				switch(this.time_a.substring(0,1)){
				case 'A' : timeA = '월'; break;
				case 'B' : timeA = '화'; break;
				case 'C' : timeA = '수'; break;
				case 'D' : timeA = '목'; break;
				case 'E' : timeA = '금'; break;
				}
				if(this.time_b != null){
					switch(this.time_b.substring(0,1)){
					case 'A' : timeB = '월'; break;
					case 'B' : timeB = '화'; break;
					case 'C' : timeB = '수'; break;
					case 'D' : timeB = '목'; break;
					case 'E' : timeB = '금'; break;
					}
				}
				if(this.inwon >0){
					output+= '<tr>'
					output+= '<td>'+ this.major_code +"-"+ this.sub_code+ '</td>';
					output+= '<td>'+ this.sub_name + '&nbsp;&nbsp;</td>';
					output+= '<td align="center"><a href="/Turkey/pro_att?time='+this.time_a+'&year='+this.year+'&semester='+this.semester+'">'+ timeA + '</a></td>';
					output+= '<td align="center"><a href="/Turkey/pro_att?time='+this.time_b+'&year='+this.year+'&semester='+this.semester+'">'+ timeB + '</a></td>';
					output+= '<td align="center">'+ this.inwon + '</td>';
					output+= '<td align="center" style="border-right:none;"><a href="/Turkey/pro_stugrade?major_code='+this.major_code+'&sub_code='+this.sub_code+'&year='+this.year+'&semester='+this.semester+'">성적관리</a></td>';
					output+= '</tr>'
				}else{
					output+= '<tr>'
					output+= '<td>'+ this.major_code +"-"+ this.sub_code+ '</td>';
					output+= '<td>'+ this.sub_name + '&nbsp;&nbsp;</td>';
					output+= '<td align="center">'+ timeA + '</td>';
					output+= '<td align="center">'+ timeB + '</td>';
					output+= '<td align="center">'+ this.inwon + '</td>';
					output+= '<td align="center" style="border-right:none;">성적관리</td>';
					output+= '</tr>'
				}

			});
				output+= '</table>';
			document.getElementById('result').innerHTML = output;            
		}
	}) 
});
</script>