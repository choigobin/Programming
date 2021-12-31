<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String season = request.getParameter("season");
	
	response.sendRedirect("result2.jsp?name="+URLEncoder.encode(name, "utf-8")
			+"&gender="+gender+"&season="+URLEncoder.encode(season,"utf-8"));
%>
