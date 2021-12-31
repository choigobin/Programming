<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String passwd = request.getParameter("passwd");
	String gubun = request.getParameter("gubun");
	String zip = request.getParameter("zip");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
이름 = <%=name %>
아이디 = <%=userid %>
비밀번호 = <%=passwd %>
전화번호 = <%=tel %>
이메일 = <%=email %>
<%=gubun %> <%=zip %>
<%=addr1 %>
<%=addr2 %>
</pre>
</body>
</html>