<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>    
<%@ include file="/header.jsp" %>
	
	<div class="slider">
	    <div><img src="/images/a1.jpg" alt="" title="광안리"></div>
	    <div><img src="/images/a2.jpg" alt="" title="요코하마"></div>
	    <div><img src="/images/a3.jpg" alt="" title="지리산 천왕봉"></div>
  	</div>

	
	<div class="indexgallery">
			<div class="indextitle">
				<h2>포트폴리오</h2>
				<span><a href="/portfolio/portfolio.jsp">MORE</a></span>
			</div>
			<ul>
			<%
			PortfolioDao daoPortfolio = new PortfolioDao();
			List<PortfolioVO> listPortfolio = daoPortfolio.selectPortfolio(1);
			int PortfolioEnd = 1;
			for(PortfolioVO vo : listPortfolio){
				PortfolioEnd ++;
				%>
				<li>
				<%
				String text = vo.getContents();
				Pattern ptn = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
				Matcher m = ptn.matcher(text);
				if(m.find()){%>
					<a href="/portfolio/portfolioview.jsp?no=<%=vo.getNo() %>">
					<%=m.group()%>
					</a>
				<%}%>
				</li>
				<%
				if(PortfolioEnd >3) break;
			}
			%>	
			</ul>
	</div>	
	<div class="bbs_wrap">
		<div class="bbs_left">
			<h2 class="title">공지시항</h2>
			<ul>
			<%
			NoticeDao daoNotice = new NoticeDao();
			List<NoticeVO> listNotice = daoNotice.selectNotice(1);
			int noticeEnd = 1;
			for(NoticeVO vo : listNotice){
				noticeEnd ++;
				%>
				<li><a href="/notice/noticeview.jsp?no=<%=vo.getNo() %>"><%=vo.getTitle() %></a></li>
				<%
				if(noticeEnd >5) break;
			}
			%>
			</ul>
			<a href="/notice/notice.jsp"><span class="fa fa-plus plus"></span></a>
		</div>
		<div class="bbs_right">
			<h2 class="title">질문답변</h2>
			<ul>
			<%
			QaDao daoQa = new QaDao();
			List<QaVO> listQa = daoQa.selectQa(1);
			int qaEnd = 1;
			for(QaVO vo : listQa){
				qaEnd ++;
				%>
				<li><a href="/qa/qaview.jsp?no=<%=vo.getNo() %>"><%=vo.getTitle() %></a></li>
				<%
				if(qaEnd >5) break;
			}
			%>
			</ul>
			<a href="/qa/qa.jsp"><span class="fa fa-plus plus"></span></a>
		</div>
	</div>
	
<%@ include file="/footer.jsp" %>