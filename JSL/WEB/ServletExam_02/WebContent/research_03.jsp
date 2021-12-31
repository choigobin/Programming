<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String season = request.getParameter("season");
	
	request.setAttribute("name", name);
	request.setAttribute("gender", gender);
	request.setAttribute("season", season);
	
	RequestDispatcher distpatch = request.getRequestDispatcher("result.jsp");
	distpatch.forward(request, response);
	
%>
