<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${row==1 }">
			<script type="text/javascript">
				alert("등록되었습니다.");
				location.replace("/Guest/guest_list");
			</script>
		</c:when>
		<c:when test="${row==0 }">
			<script type="text/javascript">
				alert("등록실패 \n 다음에....");
				histroy.back();
			</script>
		</c:when>
	</c:choose>
</body>
</html>