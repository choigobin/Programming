<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">공지사항</h2>
	</div>
	
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">공지사항</caption>
			<colgroup>
				<col width="10%">
				<col width="50%">
				<col width="10%">
				<col width="20%">
				<col width="15%">
			</colgroup>
			<tbody>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
<%
NoticeDao dao = new NoticeDao();
String pg = request.getParameter("pg")==null ? "1" : request.getParameter("pg");
int now = Integer.parseInt(pg);
if(now<1) now = 1;
int max = (dao.countNotice()+9)/10;
List<NoticeVO> list = dao.selectNotice(now);
for(NoticeVO vo : list){
%>
	<tr>
		<td><%=vo.getNo() %></td>
		<td class="tleft"><a href="/notice/noticeview.jsp?no=<%=vo.getNo() %>"><%=vo.getTitle() %></a></td>
		<td>관리자</td>
		<td><%=vo.getDate() %></td>
		<td><%=vo.getReadcnt() %></td>
	</tr>
	<%
}
%>
			</tbody>
		</table>
	</div>
		
		
		<div class="paging">
			<ul>
				<li><a href="/notice/notice.jsp?pg=<%=now-1%>">이전</a></li>
				<%
				for(int x=now-2 < 1 ? 1:now-2; x<=(now+2 < max ? now+2:max); x++){
					%>
					<li><a href="/notice/notice.jsp?pg=<%=x%>"><%=x%></a></li>
					<%
				}
				%>
				<li><a href="/notice/notice.jsp?pg=<%=now+1 < max ? now+1:max%>">다음</a></li>
			</ul>
			<c:if test="${user.getGrade() eq 'A'}">
				<a href="/notice/noticewrite.jsp" class="btn-write">글쓰기</a>
			</c:if>
		</div>

</div>
<%@ include file="/footer.jsp"%>