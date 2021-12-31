<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int p,q;
	int square(int i,int j){
		int value = 1;
		int k = 0;
		while (k<j){
			value = value*i;
			k=k+1;
		}
		return value;
	}	
%>
<%
out.println("[사용자 함수 선언 및 사용 예]");
p = square(2,5);
q = square(5,2);
%>
<br /><br />2 <sup>5</sup> : <%=p %>
<br /><br />5 <sup>2</sup> : <%=q %>
