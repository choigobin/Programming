<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">포트폴리오</h2>
	</div>
		<ul class="sub-port-content">
<%
PortfolioDao dao = new PortfolioDao();
String pg = request.getParameter("pg")==null ? "1" : request.getParameter("pg");
int now = Integer.parseInt(pg);
if(now<1) now = 1;
int max = (dao.countPortfolio()+9)/10;
List<PortfolioVO> list = dao.selectPortfolio(now);
for(PortfolioVO vo : list){

%>
<li>
	<span class="date"><%=vo.getInsertdate() %></span>
		<div class="text-wrap">
			<div class="img-wrap">
				<%
				Pattern ptn = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
				Matcher m = ptn.matcher(vo.getContents());
				if(m.find()){%>
					<a href="/portfolio/portfolioview.jsp?no=<%=vo.getNo() %>">
					<%=m.group()%>
					</a>
				<%}%>
			</div>
		<div class="text-body">
	<span>No.<%=vo.getNo() %></span> | <span class=""><i class="fa fa-eye"></i><%=vo.getReadcnt() %></span>
	<a href="/portfolio/portfolioview.jsp?no=<%=vo.getNo() %>">
		<p class="title"><%=vo.getTitle() %></p>
	</a>
		</div>
		</div>
</li>
<%
}
%>
		</ul>
		
		<div class="paging">
			<ul>
				<li><a href="/portfolio/portfolio.jsp?pg=<%=now-1%>">이전</a></li>
				<%
				for(int x=now-2 < 1 ? 1:now-2; x<=(now+2 < max ? now+2:max); x++){
					%>
					<li><a href="/portfolio/portfolio.jsp?pg=<%=x%>"><%=x%></a></li>
					<%
				}
				%>
				<li><a href="/portfolio/portfolio.jsp?pg=<%=now+1 < max ? now+1:max%>">다음</a></li>
			</ul>
			<c:if test="${user.getGrade() eq 'A'}">
				<a href="/portfolio/portfoliowrite.jsp" class="btn-write">글쓰기</a>
			</c:if>
		</div>
</div>
<%@ include file="/footer.jsp"%>