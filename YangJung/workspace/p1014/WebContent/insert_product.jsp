<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	if(document.insert.id.value==""){
		alert("상품번호를 입력하세요.");
		document.insert.id.focus();
	}
	else if(document.insert.name.value==""){
		alert("상품명을 입력하세요.");
		document.insert.name.focus();
	}
	else{
		document.insert.submit();
	}
}
</script>
<style>
table{
	border: 1px solid black;
	border-collapse: collapse;
	}
tr, td{
	border: 1px solid black;
	}
a{ color: white; text-decoration: none;}

</style>
</head>
<body>
<table height="100%" width="100%">
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<tr>
<td bgcolor="gray" valign="top">
<h2 align="center">상품 정보 등록 화면</h2>
<form action="insertA02.jsp" name="insert" method="post">
<table width="80%" align="center">
<tr>
<td align="center" width=100px;>상품코드</td>
<td colspan="3"><input type="text" name="id" size=60; /></td>
</tr>
<tr>
<td align="center">상품명</td>
<td colspan="3"><input type="text" name="name" size=60; /></td>
</tr>
<tr>
<td align="center">가격</td>
<td colspan="3"><input type="text" name="price" size=60; /></td>
</tr>
<tr>
<td align="center">상세정보</td>
<td colspan="3"><input type="text" name="description" size=60; /></td>
</tr>
<tr>
<td align="center">제조사</td>
<td colspan="3"><input type="text" name="manufacturer" size=60; /></td>
</tr>
<tr>
<td align="center">분류</td>
<td ><input type="text" name="category" /></td>
<td align="center">재고수</td>
<td ><input type="text" name="instock" /></td>
</tr>
<tr>
<td align="center">상태</td>
<td colspan="3">
<input type="radio" name="condition" value="신규제품" />신규제품
<input type="radio" name="condition" value="중고제품" />중고제품
<input type="radio" name="condition" value="재생제품" />재생제품
</td>
</tr>
<tr>
<td colspan="4" align="center">
<input type="button" onclick="javascript:check()" value="상품등록" /><input type="reset" value="다시작성" />
</td>
</tr>
</table>
</form>
</td>
</tr>
<jsp:include page="footer.jsp"/>
</table>
</body>
</html>