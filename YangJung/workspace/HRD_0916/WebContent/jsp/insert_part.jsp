<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Main 화면</title>
<style type="text/css">
table,th,td{border:1px solid black;}
</style>
<script type="text/javascript">
function check(){
	if(document.insert.partcode.value==""){
		alert("부품번호를 입력하세요.");
		document.insert.id.focus();
	}
	else if(document.insert.partname.value==""){
		alert("부품명을 입력하세요.");
		document.insert.name.focus();
	}
	else{
		document.insert.submit();
	}
}
</script>
</head>
<body>
<table width=100% height=100%>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<tr>
<td valign="top" height='80%' bgcolor="gray">
<form name="insert" method="post" action="part_insert.jsp" >
<span style="font-weight:bold;font-size:20px;">부품 정보 등록화면</span>
<table align="center" width=80%>
<tr>
<th width="120">부품번호</th><td colspan="3"><input type="text" size="60" name="partcode"></td>
</tr>
<tr>
<th>부품명</th><td colspan="3"><input type="text" size="60" name="partname"></td>
</tr>
<tr>
<th>모델명</th><td colspan="3"><input type="text" size="60" name="model"></td>
</tr>
<tr>
<th>규격</th><td colspan="3"><input type="text" size="60" name="standard"></td>
</tr>
<tr>
<th>단위</th><td colspan="3"><input type="text" size="60" name="unit"></td>
</tr>
<tr>
<th>매입가</th><td><input type="text" size="20" name="purchase"></td>
<th>매출가</th><td><input type="text" size="20" name="sales"></td>
</tr>
<tr>
<th>메모</th><td colspan="3"><textarea name="memo" rows="5" cols="60"></textarea></td>
</tr>
<tr>
<th colspan="2">
<button type="button" onclick="javascript:check()">고객등록</button> <button type="reset">다시작성</button>
</th>
</tr>
</table>
</form>
</td>
</tr>
<jsp:include page="footer.jsp"/>
</table>
</body>
</html>