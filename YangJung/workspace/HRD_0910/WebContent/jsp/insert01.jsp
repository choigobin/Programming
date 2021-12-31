<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>main화면</title>
<script type="text/javascript">
function checkwrite(){
	if(document.insform.name.value==""){
		alert("이름이 입력되지 않았습니다.");
		document.isnform.name.focus();
	}
	else if(document.insform.id.value==""){
		alert("사원번호가 입력되지 않았습니다.");
		document.isnform.id.focus();
	}
	else if(document.insform.duty.value==""){
		alert("직책이 입력되지 않았습니다.");
		document.isnform.duty.focus();
	}
	else if(document.insform.phone.value==""){
		alert("연락처가 입력되지 않았습니다.");
		document.isnform.phone.focus();
	}
	else{
		document.insform.submit();
	}
}

</script>
</head>
<body>
<table width=100% height=100% border="0" cellpading="0" celspacing="0" align="center">
<jsp:include page="header.jsp" flush="false"/>
<jsp:include page="nav.jsp" flush="false"/>
<tr>
	<td bgcolor="gray" valign="top" height="80%">
		<p align="center" style="font-size:20px">인사관리 사원 등록 화면</p>
		<form name="insform" method="post" action="insert_process.jsp">
		<table border="1" align="center">
			<tr>
				<th width="100">성명</th>
				<td width="300"><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>사원번호</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>소숙부서</th>
				<td>
					<select name="dept" style="width:100px;">
						<option value="인사부">인사부</option>
						<option value="기획부">기획부</option>
						<option value="홍보부">홍보부</option>
						<option value="영업부">영업부</option>
						<option value="경리부">경리부</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>직급</th>
				<td>
					<select name="position" style="width:100px;">
						<option value="1">1급</option>
						<option value="2">2급</option>
						<option value="3">3급</option>
						<option value="4">4급</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" name="duty"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" value="등 록" onclick="javascript:checkwrite()">&nbsp
					<input type="reset" value="취 소">
				</th>
			</tr>
		</table>
		</form>
	
	</td>
</tr>
<jsp:include page="footer.jsp" flush="false"/>
</table>
</body>
</html>