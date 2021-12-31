<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int row = (int)request.getAttribute("row");
	if(row==1){
%>
	<script>
		alert("삭제되었습니다.");
		opener.location.replace("board_list");
		self.close();
	</script>
<%
	}else{
%>
	<script>
		alert("비번오류");
		history.back();
	</script>
<%
	}
%>

