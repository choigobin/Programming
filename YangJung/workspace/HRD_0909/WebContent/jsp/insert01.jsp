<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>레이아웃</title>
<script type="text/javascript">
function checkwrite(){
	if(document.insform.sno.value==""){
		alert("학번이 입력되지 않았습니다.");
		document.insform.sno.focus();
	}
	else if(document.insform.sname.value==""){
		alert("성명이 입력되지 않았습니다");
		document.insform.sname.focus();
	}
	else if(document.insform.kor.value==""){
		alert("국어성적이 입력되지 않았습니다");
		document.insform.kor.focus();
	}
	else if(document.insform.eng.value==""){
		alert("영어성적이 입력되지 않았습니다");
		document.insform.eng.focus();
	}
	else if(document.insform.math.value==""){
		alert("수학성적이 입력되지 않았습니다");
		document.insform.math.focus();
	}
	else if(document.insform.hist.value==""){
		alert("역사성적이 입력되지 않았습니다");
		document.insform.hist.focus();
	}
	else{
		document.insform.submit();
	}
}
</script>
</head>
<body>
<table width="100%" height="100%" border="0" cellpading="0" celspacing="0" align="center">
<jsp:include page="header.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<tr bgcolor="gray">
	<td align="center">
		<p style="font-size:20px; font-weight:bold;">
		학생 성적 입력</p>
		<form name="insform" method="post" action="insert_process.jsp">
		<table border="1" align="center">
			<tr>
				<th width="100">학번</th>
				<td width="200">
				<input type="text" size="20" name="sno"></td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="text" name="kor"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="text" name="eng"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="text" name="math"></td>
			</tr>
			<tr>
				<th>역사</th>
				<td><input type="text" name="hist"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="button" value="성적저장" onclick="javascript:checkwrite()" /></td>
			</tr>
		</table>
		</form>
	</td>
</tr>
<jsp:include page="footer.jsp" flush="false" />
</table>
</body>
</html>