<%@page import="model.GuestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	GuestDAO dao = GuestDAO.getInstance();
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	dao.insert(name, subject, contents);
%>
<script type="text/javascript">
 alert("등록완료");
 location.href="guest_list.jsp";
</script>