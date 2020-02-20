<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <c:if test="${row != 0}">	
	<script>
		alert("수정되었습니다");
		location.href="NoticeServlet?cmd=notice_list&page=${nowpage}";
	</script>
	</c:if>
	<c:if test="${row==0 }">
	<script>
		alert("수정에 실패하였습니다.\n 다음에 다시 등록해 주세요");
		history.back();
	</script>
	</c:if>

