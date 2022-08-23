<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "page man");
	request.setAttribute("name", "request man");
	session.setAttribute("name", "session man");
	application.setAttribute("name", "application man");
	
	System.out.println("FirstPage");
	System.out.println("하나의 페이지 속성 : "+pageContext.getAttribute("name"));
	System.out.println("하나의 요청속성 : "+request.getAttribute("name"));
	System.out.println("하나의 객체 속성 : "+session.getAttribute("name"));
	System.out.println("하나의 애플리케이션 속성 : "+application.getAttribute("name"));
	
	request.getRequestDispatcher("page02.jsp").forward(request, response);
%>