<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="p1014.VO" %>
<%@ page import="p1014.DAO" %>
<%
String birth = request.getParameter("birth");

SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");




VO vo =new VO();
vo.setId(Integer.parseInt(request.getParameter("id")));
vo.setPassword(request.getParameter("password"));
vo.setName(request.getParameter("name"));
vo.setGender(request.getParameter("gender"));
vo.setBirth(transFormat.parse(birth));
vo.setMail(request.getParameter("email1")+request.getParameter("email2"));
vo.setPhone(request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3"));
vo.setAddress(request.getParameter("address"));
vo.setNickname(request.getParameter("nick"));

DAO dao = DAO.getInstance();
dao.insert(vo);
response.sendRedirect("insert_member.jsp");
%>