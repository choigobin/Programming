<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	int row = Integer.parseInt(request.getParameter("row"));
%>
<c:if test="${row ==1 }">
	<script>
		window.opener.location.href="pds_list?page=1";
		self.close();
	</script>
</c:if>
<c:if test="${row ==0 }">
	<script>
		alert("비번오류");
		history.back();
	</script>
</c:if>
<body>
${row }
<h1>${row }asdfasdfasdf</h1>
</body>
