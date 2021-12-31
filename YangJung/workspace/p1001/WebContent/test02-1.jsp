<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
	String gender = request.getParameter("gender");
	String[] hobbyarray = request.getParameterValues("hobby");
	String job = request.getParameter("job");
	request.setCharacterEncoding("utf-8");
	String hobby = "";
	for(int i=0;i<hobbyarray.length;i++){
		hobby=hobby+" "+hobbyarray[i];
	}
	
	out.println("아 이 디 :"+id);
	out.println("패스워드 :"+pwd);
	out.println("이 름 :"+name);
	out.println("연 락 처 :"+tel);
	out.println("성 별 :"+gender);
	out.println("취 미 :"+hobby);
	out.println("직 업 :"+job);
%>
</pre>
</body>
</html>