<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/header.jsp" %>
	
	<div class="slider">
	    <div><img src="images/a1.jpg" alt="" title="배움의 즐거움이 있는곳"></div>
	    <div><img src="images/a2.jpg" alt="" title="나에게 주는 만큼"></div>
	    <div><img src="images/a3.jpg" alt="" title="나에게도 많은 축복이 있습니다"></div>
  	</div>

	
	<div class="indexgallery">
			<div class="indextitle">
				<h2>포트폴리오</h2>
				<span><a href="/portfolio/portfolio.jsp">MORE</a></span>
			</div>
			<ul>
				<li><a href=""><img src="images/shop1.jpg"></a></li>
				<li><a href=""><img src="images/shop2.jpg"></a></li>
				<li><a href=""><img src="images/shop3.jpg"></a></li>
			</ul>
	</div>
	
	
	<div class="bbs_wrap">
		<div class="bbs_left">
			<h2 class="title">공지시항</h2>
			<ul>
			<%
			NoticeDao dao = new NoticeDao();
			List<NoticeVO> list = dao.selectNotice(1);
			int noticeEnd = 1;
			for(NoticeVO vo : list){
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
				<li><a href="#">이클립스 다운로드</a></li>
				<li><a href="#">JSP강좌 PDF</a></li>
				<li><a href="#">JAVA 환경설정 파일 설명서</a> </li>
				<li><a href="#">동영상 강좌 자료실</a></li>
				<li><a href="#">스프링 강좌 자료 다운</a></li>
			</ul>
			<a href="/qa/qa.jsp"><span class="fa fa-plus plus"></span></a>
		</div>
	</div>
	
<%@ include file="/footer.jsp" %>













