<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="insert" class="model.InsertBean" >
	<jsp:setProperty name="insert" property="*"/>
</jsp:useBean>
<title>useBean</title>
아이디 : <jsp:getProperty property="userid" name="insert"/> <br>
이름 : <%= insert.getName() %> <br>
이메일 : <%= insert.getEmail() %> <br>
계절 주소 : <jsp:getProperty property="season" name="insert"/> <br>
계절 : <jsp:getProperty property="seasonSTR" name="insert"/> <br>
<%
	DAO dao = new DAO();
	String x = dao.test(insert);
	String y = dao.test2(insert);
%>
<%=x %> <br>
<%=y %>
