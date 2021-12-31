<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="p1014.VO" %>
<%@ page import="p1014.DAO" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<table width="100%" align="center">
<tr >
<th>id</th><th>성명</th><th>패스워드</th><th>성별</th><th>생년월일</th><th>이메일</th><th>휴대폰</th><th>주소</th><th>닉네임</th>
</tr>
<%
	request.setCharacterEncoding("utf-8");
	DAO dao = DAO.getInstance();
	ArrayList<VO> list = dao.select();
	
	for(VO vo : list){
%>
	<tr>
		<td><%=vo.getId() %></td>
		<td><%=vo.getName() %></td>
		<td><%=vo.getPassword() %></td>
		<td><%=vo.getGender() %></td>
		<td><%=vo.getBirth() %></td>
		<td><%=vo.getMail() %></td>
		<td><%=vo.getPhone() %></td>
		<td><%=vo.getAddress() %></td>
		<td><%=vo.getNickname() %></td>
	</tr>

<%
	}%>
</table>
</td>
</tr>
<jsp:include page="footer.jsp"/>
</table>
</body>
</html>