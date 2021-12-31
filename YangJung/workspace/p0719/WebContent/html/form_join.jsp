<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%><%request.setCharacterEncoding("utf-8"); %>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String pswd = request.getParameter("pswd");
String address = request.getParameter("adr");
String tel1 = request.getParameter("hp1");
String tel2 = request.getParameter("hp2");
String tel3 = request.getParameter("hp3");
String sex = request.getParameter("sex");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h4>아이디 :<%=id %></h4>
<h4>이름 :<%=name %></h4>
<h4>비밀번호 :<%=pswd %></h4>
<h4>주소 :<%=address %></h4>
<h4>전화번호 :<%=tel1 %>-<%=tel2 %>-<%=tel3 %></h4>
<h4>성별 :<%=sex %></h4>

</body>
</html>