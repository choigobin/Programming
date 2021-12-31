<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String pass = request.getParameter("pwd");
	
	if(name.equals("admin") && pass.equals("1234")){
		response.sendRedirect("response-success.html");
	}else{
		response.sendRedirect("response-fail.html");
	}

%>
