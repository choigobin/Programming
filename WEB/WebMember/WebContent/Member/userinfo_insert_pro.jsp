<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String name=request.getParameter("name");
	String userid=request.getParameter("userid");
	String passwd=request.getParameter("passwd");
	String gubun=request.getParameter("gubun");
	String tel=request.getParameter("tel");
	String email=request.getParameter("email");
	String[] fa=request.getParameterValues("fa");
	String job=request.getParameter("job");
	String intro=request.getParameter("intro");
	String str="";
	if(fa !=null){
		str=fa[0];
		for(int x=1; x<fa.length;x++){
			str+=","+fa[x];
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=fa %><br>
	<%=str %>
	<a href="userinfo_modify.jsp">정보수정</a>
</body>
</html>