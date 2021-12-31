<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<br/><br/><br/>
<script type="text/javascript">
	function go() {
		if(frm.test.value<0 || frm.test.value>100){
			alert("0~100 사이의 숫자만 입력가능 합니다.");
			frm.test.focus();
		}
	}
</script>
<form name="frm">
<table>
	<tr>
		<th>숫자</th>
		<td>
			<input type="text" name="test">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" onclick="go()" value="버튼">
		</td>
	</tr>
</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>