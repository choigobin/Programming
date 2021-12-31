<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
PortfolioVO vo = new PortfolioVO();
PortfolioDao dao = new PortfolioDao();
vo = dao.viewPortfolio(no);
dao.readPortfolio(no);
%>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title"><%=vo.getTitle() %></h2>
		<p class="sub-view-wd">관리자 | <%=vo.getInsertdate() %></p>
	</div>
	<div class="sub-view-contnet">
		<%=vo.getContents() %>
	</div>
	
	<div class="sub-view-bottom">
	<c:if test="${user.getGrade() eq 'A'}">
		<a href="/portfolio/portfolioupdate.jsp?no=<%=no %>" class="btn-modify">수정</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" class="btn-delete" onclick="avent();">삭제</a>&nbsp;&nbsp;
	</c:if>
		<a href="/portfolio/portfolio.jsp" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("<%=no+"번 포트폴리오를 삭제하겠습니까?"%>") == true) {
		location.href="/Portfoliodelete.do?no=<%=no%>";
	}else {
		return;
	}
}
</script>
<%@ include file="/footer.jsp"%>