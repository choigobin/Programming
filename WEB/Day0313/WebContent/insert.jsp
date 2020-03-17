<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<br/><br/><br/>
<p align="center">생산관리 등록화면</p>
<form name="insertfrm">
<table align="center">
	<tr>
		<td>
			&nbsp;&nbsp;● 제품코드 
		</td>
		<td>
			<input type="text" name="">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;&nbsp;● 제품이름 
		</td>
		<td>
			<input type="text" name="">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;&nbsp;● 제품원가 
		</td>
		<td>
			<input type="text" name="">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;&nbsp;● 목표수량
		</td>
		<td>
			<input type="text" name="">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;&nbsp;● 재고수량 
		</td>
		<td>
			<input type="text" name="">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;&nbsp;● 출고가
		</td>
		<td>
			<input type="text" name="">
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;&nbsp;● 제품원가
		</td>
		<td>
			 <select name="">
			 	<option value="A">컴퓨터</option>
			 	<option value="B">냉장고</option>
			 	<option value="C">냉장소모품</option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" onclick="" value="등록">
			<input type="button" onclick="location.href('index.jsp')" value="메인화면">
		</td>
	</tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>